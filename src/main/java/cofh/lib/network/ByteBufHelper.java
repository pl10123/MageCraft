package cofh.lib.network;

import io.netty.buffer.ByteBuf;

public final class ByteBufHelper {

	public static int readVarInt(ByteBuf data) {

		int r = 0;
		int i = 0;
		byte b;

		do {
			b = data.readByte();
			r |= (b & 127) << i++ * 7;

			if (i > 5) {
				throw new RuntimeException("VarInt too big");
			}
		} while ((b & 128) == 128);

		return r;
	}

	public static void writeVarInt(int in, ByteBuf out) {

		if (in == 0) {
			out.writeByte(0);
		}
		while (in != 0) {
			out.writeByte(in & 127 | ((in & ~0x7F) != 0 ? 128 : 0));
			in >>>= 7;
		}
	}

	public static String readString(ByteBuf data) {

		int utflen = readVarInt(data);
		byte[] bytearr = null;
		char[] chararr = null;
		bytearr = new byte[utflen];
		chararr = new char[utflen];

		int c, char2, char3;
		int count = 0;
		int chararr_count = 0;

		data.readBytes(bytearr, 0, utflen);

		while (count < utflen) {
			c = bytearr[count] & 0xff;
			if (c > 127) {
				break;
			}
			++count;
			chararr[chararr_count++] = (char) c;
		}

		while (count < utflen) {
			c = bytearr[count] & 0xff;
			switch (c >> 4) {
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
				/* 0xxxxxxx */
				++count;
				chararr[chararr_count++] = (char) c;
				break;
			case 12:
			case 13:
				/* 110x xxxx 10xx xxxx */
				count += 2;
				if (count > utflen) {
					throw new IllegalArgumentException("malformed input: partial character at end");
				}
				char2 = bytearr[count - 1];
				if ((char2 & 0xC0) != 0x80) {
					throw new IllegalArgumentException("malformed input around byte " + count);
				}
				chararr[chararr_count++] = (char) (((c & 0x1F) << 6) | (char2 & 0x3F));
				break;
			case 14:
				/* 1110 xxxx 10xx xxxx 10xx xxxx */
				count += 3;
				if (count > utflen) {
					throw new IllegalArgumentException("malformed input: partial character at end");
				}
				char2 = bytearr[count - 2];
				char3 = bytearr[count - 1];
				if (((char2 & 0xC0) != 0x80) || ((char3 & 0xC0) != 0x80)) {
					throw new IllegalArgumentException("malformed input around byte " + (count - 1));
				}
				chararr[chararr_count++] = (char) (((c & 0x0F) << 12) | ((char2 & 0x3F) << 6) | ((char3 & 0x3F) << 0));
				break;
			default:
				/* 10xx xxxx, 1111 xxxx */
				throw new IllegalArgumentException("malformed input around byte " + count);
			}
		}
		// The number of chars produced may be less than utflen
		return new String(chararr, 0, chararr_count);
	}

	public static void writeString(String str, ByteBuf out) {

		int strlen = str.length();
		int utflen = 0;
		int c, count = 0;
		boolean hasLarge = false;

		/* use charAt instead of copying String to char array */
		for (int i = 0; i < strlen; ++i) {
			c = str.charAt(i);
			if ((c >= 0x0001) && (c <= 0x007F)) {
				utflen++;
			} else if (c > 0x07FF) {
				utflen += 3;
				hasLarge = true;
			} else {
				utflen += 2;
				hasLarge = true;
			}
		}

		if (utflen < 0) {
			throw new IllegalArgumentException("encoded string too long: " + utflen + " bytes");
		}

		byte[] bytearr = new byte[utflen];

		writeVarInt(utflen, out);

		int i = 0;
		if (!hasLarge) {
			for (; i < strlen; ++i) {
				bytearr[count++] = (byte) str.charAt(i);
			}
		}

		for (; i < strlen; ++i) {
			c = str.charAt(i);
			if ((c >= 0x0001) && (c <= 0x007F)) {
				bytearr[count++] = (byte) c;

			} else if (c > 0x07FF) {
				bytearr[count++] = (byte) (0xE0 | ((c >> 12) & 0x0F));
				bytearr[count++] = (byte) (0x80 | ((c >> 6) & 0x3F));
				bytearr[count++] = (byte) (0x80 | ((c >> 0) & 0x3F));
			} else {
				bytearr[count++] = (byte) (0xC0 | ((c >> 6) & 0x1F));
				bytearr[count++] = (byte) (0x80 | ((c >> 0) & 0x3F));
			}
		}
		out.writeBytes(bytearr);
	}

}
