module Region ( Region, newR, foundR, linkR, tunelR, connectedR, linkedR, delayR, availableCapacityForR, usedCapacityForR )
   where

import link

data Region = Reg [City] [Link] [Tunel] deriving (Show)

newR :: Region
newR = Reg [] [] []

foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg cities links tunnels) city | not (elem city cities) = Reg (city : cities) links tunnels
                                       | oterwhise = error "Ya xiste una ciudad con ese nombre, ingrese otro."
linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR (Reg cities links tunnels) city_1 city_2 quality | elem city_1 cities && elem city_2 cities = Reg cities links ++ [newL city_1 city_2 quality] tunnels
                                   | not (elem city_1 cities) = error "La primera ciudad no se encuentra en la region."
                                   | oterwhise = error "La segunda ciudad no se encuentra en la region."

tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
tunelR (Reg cities links tunnels) listCity | lenght listCity < 2 = Reg cities links tunnels
                                           | isPossibleT && capacityLinkForT getLinks((Reg cities links tunnels) listCity) = Reg cities links tunnels ++ newT Tun getLinks
                                           | oterwhise = error "No es posible hacer el tunel ya que xisten ciudades no linkeadas." 

connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
connectedR ( Reg _ _ tunnels)  city_1 city_2 = any ( \tunnel -> connectsT city_1 city_2 tunnel ) tunnels

linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
linkedR (Reg _ links _) city_1 city_2 = any ( \link linksL city_1 city_2 link ) links

delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
delayR (Reg cities links tunnels) city_1 city_2 =
   let tunnelss = filter (\tunnel -> connectsT city_1 city_2 tunnel) (tunnels)
   in sum $ map delayT tunnelss

availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades
availableCapacityForR region city_1 city_2 = capacityL head(getLinks region city_1:city_2) 

isPossibleT :: Region -> [City] -> Bool
isPossibleT _ [] = True
isPossibleT _ [_] = True
isPossibleT (Reg _ links _) (city_1: city_2: city_rest) = if any ( \link -> linksL city_1 city_2) links
                                                            then possibleT (Reg _ links _) (city_2: city_rest)
                                                         else False   
getLinks :: Region -> [City] -> [Links]
getLinks (Reg _ links _) [] = []
getLinks (Reg _ links _) [_] = []
getLinks (Reg _ links _) (city_1: city_2: city_rest) = let linksTunel = filter ( \link LinksL city_1 city_2  link ) links
                                                       in linksTunel ++ getLinks (Reg _ links _) (city_2: city_rest)

capacityLinkForT :: [Links] -> Bool
capacityLinkForT [] = True  
capacityLinkForT (link:rest_links) = if capacityL link > 0 
                                       then capacityLinkForT rest_links 
                                     else False                                                   
