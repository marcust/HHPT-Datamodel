/*
 * $ Id $
 * (c) Copyright 2009 freiheit.com technologies gmbh
 *
 * This file contains unpublished, proprietary trade secret information of
 * freiheit.com technologies gmbh. Use, transcription, duplication and
 * modification are strictly prohibited without prior written consent of
 * freiheit.com technologies gmbh.
 *
 * Initial version by Marcus Thiesen (marcus.thiesen@freiheit.com)
 */
package org.thiesen.hhpt.shared.io;

import java.nio.ByteBuffer;

public class ByteBufferWrapper implements ReadableByteInput {
    
    private final ByteBuffer _buffer;
    
    public ByteBufferWrapper( final ByteBuffer mapFile ) {
        _buffer = mapFile;
    }

    public byte get() {
         return _buffer.get();
    }

    public boolean hasRemaining() {
        return _buffer.hasRemaining();
    }

}
