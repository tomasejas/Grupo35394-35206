module Link ( Link, newL, linksL, connectsL, capacityL, delayL )
   where

import city
import quality

data Link = Lin City City Quality deriving (Eq, Show)

newL :: City -> City -> Quality -> Link -- genera un link entre dos ciudades distintas
newL city_1 city_2 quality = Lin city_1 city_2 quality

connectsL :: City -> Link -> Bool   -- indica si esta ciudad es parte de este link
connectsL city ( Lin city_1 city_2 _ ) = city == city_1 || city == city_2

linksL :: City -> City -> Link -> Bool -- indica si estas dos ciudades distintas estan conectadas mediante este link
linksL city_1 city_2 ( Lin c1 c2 _ ) = ( c1 == city_1 && c2 == city_2 ) || ( c1 == city_2 && c2 == city_1 )

capacityL :: Link -> Int
capacityL ( Lin _ _ quality ) = capacityQ quality

delayL :: Link -> Float     -- la demora que sufre una conexion en este canal
delayL ( Lin _ _ quality ) = delayQ quality