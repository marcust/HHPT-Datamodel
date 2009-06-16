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

package org.thiesen.hhpt.shared.model.tag;


public class HighwayTag extends Tag {
 
    private final String _value;

    private HighwayTag( final String value ) {
        super( StationTypeTagKey.HIGHWAY );
        _value = value;
    }

    public static HighwayTag withValue( final String value ) {
        return new HighwayTag( value );
        
    }

    @Override
    protected boolean valueEquals( final String value ) {
        return _value.equalsIgnoreCase( value );
    }

    
    
}
