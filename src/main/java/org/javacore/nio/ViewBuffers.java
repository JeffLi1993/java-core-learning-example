package org.javacore.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

/*
 * Copyright [2015] [Jeff Lee]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * @author Jeff Lee
 * @since 2015-10-13 20:40:35
 * 不同视图下的缓冲区
 */
public class ViewBuffers {
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[]{0,0,0,0,0,0,0,'a'});
        bb.rewind();
        System.out.print("Byte Buffer ");
        while (bb.hasRemaining())
            System.out.print(bb.position() + " -> " + bb.get() + ", ");
        System.out.println();

        CharBuffer cb = ((ByteBuffer)bb.rewind()).asCharBuffer();
        System.out.print("Char Buffer ");
        while (cb.hasRemaining())
            System.out.print(cb.position() + " -> " + cb.get() + ", ");
        System.out.println();

        ShortBuffer sb = ((ByteBuffer)bb.rewind()).asShortBuffer();
        System.out.print("Short Buffer ");
        while (sb.hasRemaining())
            System.out.print(sb.position() + " -> " + sb.get() + ", ");
        System.out.println();

        IntBuffer ib = ((ByteBuffer)bb.rewind()).asIntBuffer();
        System.out.print("Int Buffer ");
        while (ib.hasRemaining())
            System.out.print(ib.position() + " -> " + ib.get());
        System.out.println();

        FloatBuffer fb = ((ByteBuffer)bb.rewind()).asFloatBuffer();
        System.out.print("Float Buffer ");
        while (fb.hasRemaining())
            System.out.print(fb.position() + " -> " + fb.get() + ", ");
        System.out.println();

        LongBuffer lb = ((ByteBuffer)bb.rewind()).asLongBuffer();
        System.out.print("Long Buffer ");
        while (lb.hasRemaining())
            System.out.print(lb.position() + " -> " + lb.get() + ", ");
        System.out.println();

        DoubleBuffer db = ((ByteBuffer)bb.rewind()).asDoubleBuffer();
        System.out.print("Double Buffer ");
        while (db.hasRemaining())
            System.out.print(db.position() + " -> " + db.get() + ", ");
        System.out.println();
    }
}
