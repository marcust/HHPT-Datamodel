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
package org.thiesen.hhpt.shared.model.position;


public abstract class GeoCoordValue extends Number {

    private static final long serialVersionUID = -1637536625030399715L;
    private final Double _value;
    
    protected GeoCoordValue( final Double value ) {
        _value = value;
    }
    
    public void appendWithSep( final StringBuilder builder, final char sep ) {
        builder.append( _value ).append( sep );
    }
    
    public int asValueE6() {
        return (int)Math.round( _value.floatValue() * 1E6 );
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
    
    protected boolean valueBetween( final Number min, final Number max ) {
        final double val = _value.doubleValue();
        
        return val >= min.doubleValue() && val <= max.doubleValue();
        
    }

    public Double getValue() {
        return _value;
    }
   


   
    

}
