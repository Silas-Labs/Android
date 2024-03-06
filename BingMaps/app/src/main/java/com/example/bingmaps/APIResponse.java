package com.example.bingmaps;

public class APIResponse {
   static String mapResponse= "{\n" +
            "              \"authenticationResultCode\": \"ValidCredentials\",\n" +
            "              \"brandLogoUri\": \"https://dev.virtualearth.net/Branding/logo_powered_by.png\",\n" +
            "              \"copyright\": \"Copyright © 2023 Microsoft and its suppliers. All rights reserved. This API cannot be accessed and the content and any results may not be used, reproduced or transmitted in any manner without express written permission from Microsoft Corporation.\",\n" +
            "              \"resourceSets\": [\n" +
            "                {\n" +
            "                  \"estimatedTotal\": 1,\n" +
            "                  \"resources\": [\n" +
            "                    {\n" +
            "                      \"__type\": \"Route:http://schemas.microsoft.com/search/local/ws/rest/v1\",\n" +
            "                      \"bbox\": [\n" +
            "                        0.197443,\n" +
            "                        35.09645,\n" +
            "                        0.203935,\n" +
            "                        35.131005\n" +
            "                      ],\n" +
            "                      \"id\": \"v70,h-1592458665,i0,a0,cen-US,dAAAAAAAAAAA1,y0,s1,m1,o1,t4,wfLlPjgJEyT9-qgoNxJBBQA2~ADTYOrrBSCqfAADgAYV7Dj0A0~cm9hZA2~~~~~~~~v12,wxuBh2jf3yT_eyhKdZYxBQA2~ADTYOrqRXCqfAADgAUAQ-z4C0~cm9hZA2~~~~~~~~v12,k1\",\n" +
            "                      \"distanceUnit\": \"Kilometer\",\n" +
            "                      \"durationUnit\": \"Second\",\n" +
            "                      \"routeLegs\": [\n" +
            "                        {\n" +
            "                          \"actualEnd\": {\n" +
            "                            \"type\": \"Point\",\n" +
            "                            \"coordinates\": [\n" +
            "                              0.202647,\n" +
            "                              35.09645\n" +
            "                            ]\n" +
            "                          },\n" +
            "                          \"actualStart\": {\n" +
            "                            \"type\": \"Point\",\n" +
            "                            \"coordinates\": [\n" +
            "                              0.197443,\n" +
            "                              35.131005\n" +
            "                            ]\n" +
            "                          },\n" +
            "                          \"alternateVias\": [],\n" +
            "                          \"description\": \"B8, B12\",\n" +
            "                          \"endTime\": \"/Date(1701902868044-0800)/\",\n" +
            "                          \"itineraryItems\": [\n" +
            "                            {\n" +
            "                              \"compassDirection\": \"west\",\n" +
            "                              \"details\": [\n" +
            "                                {\n" +
            "                                  \"compassDegrees\": 291,\n" +
            "                                  \"endPathIndices\": [\n" +
            "                                    10\n" +
            "                                  ],\n" +
            "                                  \"maneuverType\": \"DepartStart\",\n" +
            "                                  \"mode\": \"Driving\",\n" +
            "                                  \"roadType\": \"Street\",\n" +
            "                                  \"startPathIndices\": [\n" +
            "                                    0\n" +
            "                                  ]\n" +
            "                                }\n" +
            "                              ],\n" +
            "                              \"exit\": \"\",\n" +
            "                              \"iconType\": \"Auto\",\n" +
            "                              \"instruction\": {\n" +
            "                                \"formattedText\": null,\n" +
            "                                \"maneuverType\": \"DepartStart\",\n" +
            "                                \"text\": \"Depart and head toward B8\"\n" +
            "                              },\n" +
            "                              \"isRealTimeTransit\": false,\n" +
            "                              \"maneuverPoint\": {\n" +
            "                                \"type\": \"Point\",\n" +
            "                                \"coordinates\": [\n" +
            "                                  0.197443,\n" +
            "                                  35.131005\n" +
            "                                ]\n" +
            "                              },\n" +
            "                              \"realTimeTransitDelay\": 0,\n" +
            "                              \"sideOfStreet\": \"Unknown\",\n" +
            "                              \"tollZone\": \"\",\n" +
            "                              \"towardsRoadName\": \"B8\",\n" +
            "                              \"transitTerminus\": \"\",\n" +
            "                              \"travelDistance\": 1.345,\n" +
            "                              \"travelDuration\": 108,\n" +
            "                              \"travelMode\": \"Driving\"\n" +
            "                            },\n" +
            "                            {\n" +
            "                              \"compassDirection\": \"northwest\",\n" +
            "                              \"details\": [\n" +
            "                                {\n" +
            "                                  \"compassDegrees\": 334,\n" +
            "                                  \"endPathIndices\": [\n" +
            "                                    13\n" +
            "                                  ],\n" +
            "                                  \"maneuverType\": \"TurnRight\",\n" +
            "                                  \"mode\": \"Driving\",\n" +
            "                                  \"names\": [\n" +
            "                                    \"B8\"\n" +
            "                                  ],\n" +
            "                                  \"roadShieldRequestParameters\": {\n" +
            "                                    \"bucket\": 7209614,\n" +
            "                                    \"shields\": [\n" +
            "                                      {\n" +
            "                                        \"labels\": [\n" +
            "                                          \"B8\"\n" +
            "                                        ],\n" +
            "                                        \"roadShieldType\": 1\n" +
            "                                      }\n" +
            "                                    ]\n" +
            "                                  },\n" +
            "                                  \"roadType\": \"Highway\",\n" +
            "                                  \"startPathIndices\": [\n" +
            "                                    10\n" +
            "                                  ]\n" +
            "                                }\n" +
            "                              ],\n" +
            "                              \"exit\": \"\",\n" +
            "                              \"iconType\": \"Auto\",\n" +
            "                              \"instruction\": {\n" +
            "                                \"formattedText\": null,\n" +
            "                                \"maneuverType\": \"TurnRight\",\n" +
            "                                \"text\": \"Turn right onto B8\"\n" +
            "                              },\n" +
            "                              \"isRealTimeTransit\": false,\n" +
            "                              \"maneuverPoint\": {\n" +
            "                                \"type\": \"Point\",\n" +
            "                                \"coordinates\": [\n" +
            "                                  0.201283,\n" +
            "                                  35.12\n" +
            "                                ]\n" +
            "                              },\n" +
            "                              \"realTimeTransitDelay\": 0,\n" +
            "                              \"sideOfStreet\": \"Unknown\",\n" +
            "                              \"tollZone\": \"\",\n" +
            "                              \"transitTerminus\": \"\",\n" +
            "                              \"travelDistance\": 0.13,\n" +
            "                              \"travelDuration\": 71,\n" +
            "                              \"travelMode\": \"Driving\"\n" +
            "                            },\n" +
            "                            {\n" +
            "                              \"compassDirection\": \"west\",\n" +
            "                              \"details\": [\n" +
            "                                {\n" +
            "                                  \"compassDegrees\": 257,\n" +
            "                                  \"endPathIndices\": [\n" +
            "                                    27\n" +
            "                                  ],\n" +
            "                                  \"maneuverType\": \"TurnLeft\",\n" +
            "                                  \"mode\": \"Driving\",\n" +
            "                                  \"names\": [\n" +
            "                                    \"Eldoret Kapsabet Road\"\n" +
            "                                  ],\n" +
            "                                  \"roadShieldRequestParameters\": {\n" +
            "                                    \"bucket\": 7209614,\n" +
            "                                    \"shields\": [\n" +
            "                                      {\n" +
            "                                        \"labels\": [\n" +
            "                                          \"B12\"\n" +
            "                                        ],\n" +
            "                                        \"roadShieldType\": 1\n" +
            "                                      }\n" +
            "                                    ]\n" +
            "                                  },\n" +
            "                                  \"roadType\": \"Highway\",\n" +
            "                                  \"startPathIndices\": [\n" +
            "                                    13\n" +
            "                                  ]\n" +
            "                                }\n" +
            "                              ],\n" +
            "                              \"exit\": \"\",\n" +
            "                              \"iconType\": \"Auto\",\n" +
            "                              \"instruction\": {\n" +
            "                                \"formattedText\": null,\n" +
            "                                \"maneuverType\": \"TurnLeft\",\n" +
            "                                \"text\": \"Turn left onto B12 / Eldoret Kapsabet Road\"\n" +
            "                              },\n" +
            "                              \"isRealTimeTransit\": false,\n" +
            "                              \"maneuverPoint\": {\n" +
            "                                \"type\": \"Point\",\n" +
            "                                \"coordinates\": [\n" +
            "                                  0.202347,\n" +
            "                                  35.119516\n" +
            "                                ]\n" +
            "                              },\n" +
            "                              \"realTimeTransitDelay\": 0,\n" +
            "                              \"sideOfStreet\": \"Unknown\",\n" +
            "                              \"tollZone\": \"\",\n" +
            "                              \"transitTerminus\": \"\",\n" +
            "                              \"travelDistance\": 2.623,\n" +
            "                              \"travelDuration\": 269,\n" +
            "                              \"travelMode\": \"Driving\",\n" +
            "                              \"warnings\": [\n" +
            "                                {\n" +
            "                                  \"origin\": \"0.202152,35.1182\",\n" +
            "                                  \"severity\": \"Minor\",\n" +
            "                                  \"text\": \"Minor congestion\",\n" +
            "                                  \"to\": \"0.202347,35.119516\",\n" +
            "                                  \"warningType\": \"TrafficFlow\"\n" +
            "                                }\n" +
            "                              ]\n" +
            "                            },\n" +
            "                            {\n" +
            "                              \"compassDirection\": \"northwest\",\n" +
            "                              \"details\": [\n" +
            "                                {\n" +
            "                                  \"compassDegrees\": 332,\n" +
            "                                  \"endPathIndices\": [\n" +
            "                                    28\n" +
            "                                  ],\n" +
            "                                  \"maneuverType\": \"TurnRight\",\n" +
            "                                  \"mode\": \"Driving\",\n" +
            "                                  \"roadType\": \"Street\",\n" +
            "                                  \"startPathIndices\": [\n" +
            "                                    27\n" +
            "                                  ]\n" +
            "                                }\n" +
            "                              ],\n" +
            "                              \"exit\": \"\",\n" +
            "                              \"iconType\": \"Auto\",\n" +
            "                              \"instruction\": {\n" +
            "                                \"formattedText\": null,\n" +
            "                                \"maneuverType\": \"TurnRight\",\n" +
            "                                \"text\": \"Turn right\"\n" +
            "                              },\n" +
            "                              \"isRealTimeTransit\": false,\n" +
            "                              \"maneuverPoint\": {\n" +
            "                                \"type\": \"Point\",\n" +
            "                                \"coordinates\": [\n" +
            "                                  0.202328,\n" +
            "                                  35.096617\n" +
            "                                ]\n" +
            "                              },\n" +
            "                              \"realTimeTransitDelay\": 0,\n" +
            "                              \"sideOfStreet\": \"Unknown\",\n" +
            "                              \"tollZone\": \"\",\n" +
            "                              \"transitTerminus\": \"\",\n" +
            "                              \"travelDistance\": 0.04,\n" +
            "                              \"travelDuration\": 49,\n" +
            "                              \"travelMode\": \"Driving\"\n" +
            "                            },\n" +
            "                            {\n" +
            "                              \"compassDirection\": \"northwest\",\n" +
            "                              \"details\": [\n" +
            "                                {\n" +
            "                                  \"compassDegrees\": 332,\n" +
            "                                  \"endPathIndices\": [\n" +
            "                                    28\n" +
            "                                  ],\n" +
            "                                  \"maneuverType\": \"ArriveFinish\",\n" +
            "                                  \"mode\": \"Driving\",\n" +
            "                                  \"roadType\": \"Street\",\n" +
            "                                  \"startPathIndices\": [\n" +
            "                                    28\n" +
            "                                  ]\n" +
            "                                }\n" +
            "                              ],\n" +
            "                              \"exit\": \"\",\n" +
            "                              \"hints\": [\n" +
            "                                {\n" +
            "                                  \"hintType\": \"PreviousIntersection\",\n" +
            "                                  \"text\": \"The last intersection before your destination is B12 / Eldoret Kapsabet Road\"\n" +
            "                                }\n" +
            "                              ],\n" +
            "                              \"iconType\": \"Auto\",\n" +
            "                              \"instruction\": {\n" +
            "                                \"formattedText\": null,\n" +
            "                                \"maneuverType\": \"ArriveFinish\",\n" +
            "                                \"text\": \"Arrive at your destination on the right\"\n" +
            "                              },\n" +
            "                              \"isRealTimeTransit\": false,\n" +
            "                              \"maneuverPoint\": {\n" +
            "                                \"type\": \"Point\",\n" +
            "                                \"coordinates\": [\n" +
            "                                  0.202647,\n" +
            "                                  35.09645\n" +
            "                                ]\n" +
            "                              },\n" +
            "                              \"realTimeTransitDelay\": 0,\n" +
            "                              \"sideOfStreet\": \"Right\",\n" +
            "                              \"tollZone\": \"\",\n" +
            "                              \"transitTerminus\": \"\",\n" +
            "                              \"travelDistance\": 0,\n" +
            "                              \"travelDuration\": 0,\n" +
            "                              \"travelMode\": \"Driving\"\n" +
            "                            }\n" +
            "                          ],\n" +
            "                          \"routeRegion\": \"WWMX\",\n" +
            "                          \"routeSubLegs\": [\n" +
            "                            {\n" +
            "                              \"endWaypoint\": {\n" +
            "                                \"type\": \"Point\",\n" +
            "                                \"coordinates\": [\n" +
            "                                  0.202647,\n" +
            "                                  35.09645\n" +
            "                                ],\n" +
            "                                \"description\": \"road\",\n" +
            "                                \"isVia\": false,\n" +
            "                                \"locationIdentifier\": \"0|52|216|58|186|145|92|42|159|0|0|224|1|64|16|251|62|2|0.202647,35.09645\",\n" +
            "                                \"routePathIndex\": 28\n" +
            "                              },\n" +
            "                              \"startWaypoint\": {\n" +
            "                                \"type\": \"Point\",\n" +
            "                                \"coordinates\": [\n" +
            "                                  0.197443,\n" +
            "                                  35.131005\n" +
            "                                ],\n" +
            "                                \"description\": \"road\",\n" +
            "                                \"isVia\": false,\n" +
            "                                \"locationIdentifier\": \"0|52|216|58|186|193|72|42|159|0|0|224|1|133|123|14|61|0|0.197443,35.131005\",\n" +
            "                                \"routePathIndex\": 0\n" +
            "                              },\n" +
            "                              \"travelDistance\": 4.138,\n" +
            "                              \"travelDuration\": 499\n" +
            "                            }\n" +
            "                          ],\n" +
            "                          \"startTime\": \"/Date(1701902369044-0800)/\",\n" +
            "                          \"travelDistance\": 4.138,\n" +
            "                          \"travelDuration\": 499,\n" +
            "                          \"travelMode\": \"Driving\"\n" +
            "                        }\n" +
            "                      ],\n" +
            "                      \"trafficCongestion\": \"Mild\",\n" +
            "                      \"trafficDataUsed\": \"None\",\n" +
            "                      \"travelDistance\": 4.138,\n" +
            "                      \"travelDuration\": 499,\n" +
            "                      \"travelDurationTraffic\": 559,\n" +
            "                      \"travelMode\": \"Driving\"\n" +
            "                    }\n" +
            "                  ]\n" +
            "                }\n" +
            "              ],\n" +
            "              \"statusCode\": 200,\n" +
            "              \"statusDescription\": \"OK\",\n" +
            "              \"traceId\": \"7085104e63384097883b6147caa4bedc|DU00003055|0.0.0.0|DUB0009296, Leg0-DUB0009283\"\n" +
            "            }";
}
