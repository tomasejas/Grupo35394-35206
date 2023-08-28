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

--defaultQuality :: Quality
defaultQuality = newQ "Default" 1 1.0


--queremos probar connectedR

--1°: qué variables necesito?
region =  newR
region1 = foundR region cityA --1 ciudad
region2 = foundR region1 cityB --2 ciudades
region3 = linkR region2 cityA cityB defaultQuality
region4 = foundR region3 cityC
region5 = linkR region4 cityB cityC defaultQuality
region6 = linkR region5 cityA cityC linkQuality
region7 =  tunelR region6 [cityA, cityB]
region8 = tunelR region7 [cityA, cityC]
linkQuality = newQ "Link Quality" 3 2.0


testConnectedR = [
    connectedR region3 cityA cityB,             -- False
    not (connectedR region2 cityA cityB),       -- True
    not (connectedR region4 cityA cityC),       -- True
    connectedR region5 cityB cityC,             -- False
    True
    ]

testLinkedR = [
    not(linkedR region2 cityA cityB),       -- True
    linkedR region3 cityA cityB,            -- True
    not (linkedR region5 cityA cityC),      -- True
    linkedR region5 cityB cityC,            -- True
    True
    ]

testDelayR = [
    delayR region7 cityA cityB,
    delayR region8 cityA cityC
    ]   

testAvailableCapacityForR = [
    availableCapacityForR region3 cityA cityB,      -- 1
    availableCapacityForR region6 cityA cityC,      -- 3
    availableCapacityForR region5 cityA cityB       -- 1
    ]