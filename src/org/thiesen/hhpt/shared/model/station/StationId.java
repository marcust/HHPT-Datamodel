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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( ( _value == null ) ? 0 : _value.hashCode() );
        return result;
    }

    @Override
    public boolean equals( final Object obj ) {
        if ( this == obj ) {
            return true;
        }
        if ( obj == null ) {
            return false;
        }
        if ( getClass() != obj.getClass() ) {
            return false;
        }
        final StationId other = (StationId) obj;
        if ( _value == null ) {
            if ( other._value != null ) {
                return false;
            }
        } else if ( !_value.equals( other._value ) ) {
            return false;
        }
        return true;
    }

    public static StationId valueOf( final int stationId ) {
        return new StationId( Long.valueOf( stationId ) );
    }
    
    

}
