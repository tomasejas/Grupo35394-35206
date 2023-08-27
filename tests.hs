import Quality
import Point
import City
import Link
import Tunel
import Region

bue = newC "Buenos Aires" (newP 1 1)
par = newC "Paris" (newP 2 2)
lon = newC "Londres" (newP 2 1)
rom = newC "Roma" (newP 1 2)
tok = newC "Tokio" (newP 3 2)
syd = newC "Sydney" (newP 2 3)

calidad1 = newQ "buena" 4 3.0
calidad2 = newQ "mala" 3 2.0

link1 = newL rom lon calidad2
link2 = newL par tok calidad1
link3 = newL lon bue calidad1

tunel1 = newT [link1, link3, link2]
tunel2 = newT [link3, link1, link2]
tunel3 = newT [link1]
tunel4 = newT []

--TESTING POINT, CITY, QUALITY, LINK, TUNEL:

test = [capacityQ calidad1 == 4,                    --TRUE
        delayQ calidad1 == 3.0,                     --TRUE
        difP (newP 1 1) (newP 2 2) == 1.4142135,    --TRUE
        nameC bue == "Buenos Aires",                --TRUE
        distanceC bue par == 1.4142135,             --TRUE
        connectsL lon link1 == True,                --TRUE
        connectsL bue link1 == True,                --FALSE
        linksL bue par link2 == True,               --FALSE
        capacityL link1 == 3,                       --TRUE
        delayL link1 == 2.0,                        --TRUE
        usesT link1 tunel1 == True,                 --TRUE
        delayT tunel1 == 5.0,                       --FALSE
        connectsT rom tok tunel1 == True,           --TRUE
        connectsT rom bue tunel1 == False,          --TRUE
        connectsT rom bue tunel4 == False,          --TRUE
        connectsT rom lon tunel3 == True]           --TRUE

--TESTING REGION:

cityA = newC "City A" (newP 0 0)
cityB = newC "City B" (newP 1 0)
cityC = newC "City C" (newP 0 1)

defaultQuality :: Quality
defaultQuality = newQ "Default" 1 1.0

testConnectedR :: Bool                              --TRUE
testConnectedR =
  let region1 = newR 
      region2 = linkR region1 cityA cityB defaultQuality
      region3 = tunelR region2 [cityA, cityB, cityC]
  in
    connectedR region1 cityA cityB == False &&
    connectedR region2 cityA cityB == False &&
    connectedR region2 cityA cityC == False &&
    connectedR region3 cityA cityC == True

testLinkedR :: Bool                                 --TRUE
testLinkedR =
  let region = newR
      regionWithLink = linkR region cityA cityB defaultQuality
  in
    not (linkedR region cityA cityB) &&
    linkedR regionWithLink cityA cityB 

linkQuality :: Quality
linkQuality = newQ "Link Quality" 3 2.0

testDelayR :: Bool                                  --TRUE
testDelayR =
  let region = newR
      regionWithLink = linkR region cityA cityB linkQuality
      regionWithTunnel = tunelR regionWithLink [cityA, cityC, cityB]
  in
    delayR region cityA cityB == 0.0 &&
    delayR regionWithTunnel cityA cityB == 2.0

testAvailableCapacityForR :: Bool                   --TRUE
testAvailableCapacityForR =
  let region = newR
      regionWithLink = linkR region cityA cityB linkQuality
      regionWithTunnel = tunelR regionWithLink [cityA, cityB, cityC]
  in
    availableCapacityForR region cityA cityB == 0 &&
    availableCapacityForR regionWithTunnel cityA cityC == 0 &&
    availableCapacityForR regionWithLink cityA cityB == 3