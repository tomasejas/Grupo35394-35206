module Link ( Link, newL, linksL, connectsL, capacityL, delayL )
   where

data Link = Lin City City Quality deriving (Eq, Show)

newL :: City -> City -> Quality -> Link -- genera un link entre dos ciudades distintas
newL city_1 city_2 quality = Lin city_1 city_2 quality

connectsL :: City -> Link -> Bool   -- indica si esta ciudad es parte de este link
connectsL city (Lin city_1 city_2 _ ) = city == city_1 || city == city_2

linksL :: City -> City -> Link -> Bool -- indica si estas dos ciudades distintas estan conectadas mediante este link
linksL city_1 city_2 link = ( connectsL city_1 link && connectsL city_2 link )

capacityL :: Link -> Int
capacityL ( Lin _ _ ( Qua _ capacity _ ) ) = capacity

delayL :: Link -> Float     -- la demora que sufre una conexion en este canal
delayL ( Lin _ _ ( Qua _ _ delay ) ) = delay