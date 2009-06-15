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
package org.thiesen.hhpt.shared.model.station;


public class StationId extends Number {
    
    private static final long serialVersionUID = 6023954961206700964L;
    private final Long _value;
    
    private StationId( final Long value ) {
        _value = value;
    }
    
    public static StationId valueOf( final String value ) {
        return new StationId( Long.valueOf( value ) );
    }
    
    @Override
    public double doubleValue() {
        return _value.doubleValue();
    }

    @Override
    public float floatValue() {
        return _value.floatValue();
    }

    @Override
    public int intValue() {
        return _value.intValue();
    }

    @Override
    public long longValue() {
        return _value.longValue();
    }

    public void appendWithSep( final StringBuilder builder, final char sep ) {
        builder.append( _value.toString() ).append( sep );
    }

    public String stringValue() {
        return "" + _value;
        
    }

}
