/*
 * $ Id $
 * (c) Copyright 2009 Marcus Thiesen (marcus@thiesen.org)
 *
 *  This file is part of HHPT.
 *
 *  HHPT is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  HHPT is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with HHPT.  If not, see <http://www.gnu.org/licenses/>.
 *
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
