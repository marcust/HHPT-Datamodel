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
package org.thiesen.hhpt.shared.model.tag;

public abstract class Tag {

    private final StationTypeTagKey _key;
    
    public Tag( final StationTypeTagKey key ) {
        _key = key;
    }

    public boolean equals( final String key, final String value ) {
        return keyEquals( key ) && valueEquals( value );
    }
    
    protected abstract boolean valueEquals( String value );
    
    private boolean keyEquals( final String key ) {
        return _key.toString().toLowerCase().equals( key );
    }



}
