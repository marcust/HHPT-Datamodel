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

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public enum StationTypeTagKey {
    HIGHWAY, RAILWAY;

    private final static String[] LOWER_CASE_NAMES;
    
    static {
        
        final List<String> values = new LinkedList<String>();
        
        for ( final StationTypeTagKey key : values() ) {
            values.add( key.toString().toLowerCase() );
        }
        
        LOWER_CASE_NAMES = values.toArray( new String[0] );
    }
    
    public static Iterable<String> toXMLKeys() {
        return Arrays.asList( LOWER_CASE_NAMES );
    }
}
