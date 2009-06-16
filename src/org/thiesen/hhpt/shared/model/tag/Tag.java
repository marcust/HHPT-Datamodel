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
