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

import java.io.Serializable;

import org.thiesen.hhpt.shared.model.position.Latitude;
import org.thiesen.hhpt.shared.model.position.Longitude;
import org.thiesen.hhpt.shared.model.position.Position;



public class Station implements Serializable {

    private static final long serialVersionUID = 5805270188434101339L;
    
    public static final String STATION = "org.thiesen.hhpt.shared.model.station.Station";
    private final StationId _id;
    private final Position _position;
    private final StationType _type;
    private final StationName _name;
    private final Operator _operator;
    
    
    private Station( final StationId id, final Position p, final StationType t, final StationName n, final Operator o ) {
        _id = id;
        _position = p;
        _type = t;
        _name = n;
        _operator = o;
    }

    public static Station createStation( final StationId id, final Position p, final StationType t, final StationName n, final Operator o ) {
        return new Station( id, p, t, n, o );
    }
    
    public static Station createStation( final String id, final String latitude, final String longitude, final StationType type, final String name, final String operator ) {
        final StationId stationId = StationId.valueOf( id );
        final Position pos = Position.valueOf( latitude, longitude );
        final StationName stationName = StationName.valueOf( name );
        final Operator op = Operator.valueOf( operator );
        return createStation( stationId, pos, type, stationName, op );
    }

    public static Station createStation( final String id, final String latitude, final String longitude, final String type, final String name, final String operator ) {
        return createStation( id, latitude, longitude, StationType.valueOf( type ), name, operator );
    }

    
    public void appendLineTo( final StringBuilder retval ) {
        final char sep = '\0';
        _id.appendWithSep( retval, sep );
        _position.appendWithSep( retval, sep );
        _type.appendWithSep( retval, sep );
        _name.appendWithSep( retval, sep );
        _operator.appendWithSep( retval, sep );
        retval.append( '\n' );
    }

    public Position getPosition() {
        return _position;
        
    }

    public String getName() {
        return _name.asString();
    }

    public boolean isBus() {
        return _type.isBus();
        
    }

    public boolean isTrain() {
        return _type.istTrain();
        
    }

    public boolean isWithin( final int minLat, final int maxLat, final int minLon, final int maxLon ) {
        return _position.isWithin( Latitude.valueOfE6(  minLat ), Latitude.valueOfE6( maxLat ), Longitude.valueOfE6( minLon ), Longitude.valueOfE6( maxLon)  );
        
    }

    public StationId getId() {
        return _id;
    }

    public StationType getType() {
        return _type;
    }

    public Operator getOperator() {
        return _operator;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( ( _id == null ) ? 0 : _id.hashCode() );
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
        final Station other = (Station) obj;
        if ( _id == null ) {
            if ( other._id != null ) {
                return false;
            }
        } else if ( !_id.equals( other._id ) ) {
            return false;
        }
        
        return true;
    }

    
}
