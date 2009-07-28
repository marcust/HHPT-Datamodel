/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.thiesen.hhpt.shared.utils;


/**
 * Based on http://en.wikipedia.org/wiki/Geohash
 */
public class GeoHashUtils {

    // geohash's char map
    // no a's i's l's o's
    // old MacDonal wouldn't be happy
    private static char[] _base32 = {'0','1','2','3','4','5','6','7','8','9',
        'b','c','d','e','f','g','h','j','k','m',
        'n','p','q','r','s','t','u','v','w','x',
        'y','z'} ;


    private static int convert( final char c ) {

        switch ( c ) {
            case '0': return 0; 
            case '1': return 1; 
            case '2': return 2; 
            case '3': return 3; 
            case '4': return 4; 
            case '5': return 5; 
            case '6': return 6; 
            case '7': return 7; 
            case '8': return 8; 
            case '9': return 9; 
            case 'b': return 10; 
            case 'c': return 11; 
            case 'd': return 12; 
            case 'e': return 13; 
            case 'f': return 14; 
            case 'g': return 15; 
            case 'h': return 16; 
            case 'j': return 17; 
            case 'k': return 18; 
            case 'm': return 19; 
            case 'n': return 20; 
            case 'p': return 21; 
            case 'q': return 22; 
            case 'r': return 23; 
            case 's': return 24; 
            case 't': return 25; 
            case 'u': return 26; 
            case 'v': return 27; 
            case 'w': return 28; 
            case 'x': return 29; 
            case 'y': return 30; 
            case 'z': return 31; 
        }
        
        return -1;
    }


    public static int[] convert( final String geohash ) {
        final int[] retval = new int[geohash.length()];
        for ( int i = 0; i < geohash.length(); i++ ) {
            final char c = geohash.charAt( i );
            
            switch ( c ) {
                case '0': retval[i] = 0; break;
                case '1': retval[i] = 1; break;
                case '2': retval[i] = 2; break;
                case '3': retval[i] = 3; break;
                case '4': retval[i] = 4; break;
                case '5': retval[i] = 5; break;
                case '6': retval[i] = 6; break;
                case '7': retval[i] = 7; break;
                case '8': retval[i] = 8; break;
                case '9': retval[i] = 9; break;
                case 'b': retval[i] = 10; break;
                case 'c': retval[i] = 11; break;
                case 'd': retval[i] = 12; break;
                case 'e': retval[i] = 13; break;
                case 'f': retval[i] = 14; break;
                case 'g': retval[i] = 15; break;
                case 'h': retval[i] = 16; break;
                case 'j': retval[i] = 17; break;
                case 'k': retval[i] = 18; break;
                case 'm': retval[i] = 19; break;
                case 'n': retval[i] = 20; break;
                case 'p': retval[i] = 21; break;
                case 'q': retval[i] = 22; break;
                case 'r': retval[i] = 23; break;
                case 's': retval[i] = 24; break;
                case 't': retval[i] = 25; break;
                case 'u': retval[i] = 26; break;
                case 'v': retval[i] = 27; break;
                case 'w': retval[i] = 28; break;
                case 'x': retval[i] = 29; break;
                case 'y': retval[i] = 30; break;
                case 'z': retval[i] = 31; break;
            }
        }
        
        return retval;
    }


    private static int precision = 12;
    private static int[] bits = {16, 8, 4, 2, 1};

    public static void main(final String[] args) {
        final GeoHashUtils ghf = new GeoHashUtils();
        final String gc1 = ghf.encode(30, -90.0);
        final String gc2 = ghf.encode(51.4797, -0.0124);

        System.out.println(gc1);
        System.out.println(gc2);

        final double [] gd1 = ghf.decode(gc1);
        final double [] gd2 = ghf.decode(gc2);
        System.out.println(gd1[0]+ ", "+ gd1[1]);
        System.out.println(gd2[0]+ ", "+ gd2[1]);

    }

    public static String encode(final double latitude, final double longitude){
        final double[] lat_interval = {-90.0 ,  90.0};
        final double[] lon_interval = {-180.0, 180.0};

        final StringBuilder geohash = new StringBuilder();
        boolean is_even = true;
        int bit = 0, ch = 0;

        while(geohash.length() < precision){
            double mid = 0.0;
            if(is_even){
                mid = (lon_interval[0] + lon_interval[1]) / 2;
                if (longitude > mid){
                    ch |= bits[bit];
                    lon_interval[0] = mid;
                } else {
                    lon_interval[1] = mid;
                }

            } else {
                mid = (lat_interval[0] + lat_interval[1]) / 2;
                if(latitude > mid){
                    ch |= bits[bit];
                    lat_interval[0] = mid;
                } else {
                    lat_interval[1] = mid;
                }
            }

            is_even = is_even ? false : true;

            if (bit  < 4){
                bit ++;
            } else {
                geohash.append(_base32[ch]);
                bit =0;
                ch = 0;
            }
        }

        return geohash.toString();
    }

    public static double[] decode(final String geohash) {
        final double[] ge = decode_exactly(geohash);
        double lat, lon, lat_err, lon_err;
        lat = ge[0];
        lon = ge[1];
        lat_err = ge[2];
        lon_err = ge[3];

        final double lat_precision = Math.max(1, Math.round(- Math.log10(lat_err))) - 1;
        final double lon_precision = Math.max(1, Math.round(- Math.log10(lon_err))) - 1;

        lat = getPrecision(lat, lat_precision);
        lon = getPrecision(lon, lon_precision);

        return new double[] {lat, lon};
    }

    public static double[] decode_exactly (final String geohash){
        final double[] lat_interval = {-90.0 , 90.0};
        final double[] lon_interval = {-180.0, 180.0};

        double lat_err =  90.0;
        double lon_err = 180.0;
        boolean is_even = true;
        final int sz = geohash.length();
        final int bsz = bits.length;
        double latitude, longitude;
        for (int i = 0; i < sz; i++){

            final int cd = convert(geohash.charAt(i));

            for (int z = 0; z< bsz; z++){
                final int mask = bits[z];
                if (is_even){
                    lon_err /= 2;
                    if ((cd & mask) != 0){
                        lon_interval[0] = (lon_interval[0]+lon_interval[1])/2;
                    } else {
                        lon_interval[1] = (lon_interval[0]+lon_interval[1])/2;
                    }

                } else {
                    lat_err /=2;

                    if ( (cd & mask) != 0){
                        lat_interval[0] = (lat_interval[0]+lat_interval[1])/2;
                    } else {
                        lat_interval[1] = (lat_interval[0]+lat_interval[1])/2;
                    }
                }
                is_even = is_even ? false : true;
            }

        }
        latitude  = (lat_interval[0] + lat_interval[1]) / 2;
        longitude = (lon_interval[0] + lon_interval[1]) / 2;

        return new double []{latitude, longitude, lat_err, lon_err};
    }

    static double getPrecision(final double x, final double precision) {
        final double base = Math.pow(10,- precision);
        final double diff = x % base;
        return x - diff;
    }


    public static String encode( final String latitude, final String longitude ) {
       return encode( Double.parseDouble( latitude ), Double.parseDouble( longitude ) );
        
    }


}
