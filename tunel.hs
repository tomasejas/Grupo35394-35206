module Tunel ( Tunel, newT, connectsT, usesT, delayT )
   where

import link

data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel
newT links_conection = Tun links_conection

connectsT :: City -> City -> Tunel -> Bool -- inidca si este tunel conceta estas dos ciudades distintas
connectsT city_1 city_2 ( Tun links_conection ) = ( any (\link -> linksL city_1 city_2 link) links_conection ) -- nose

usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link
usesT link ( Tun links ) = link `elem` links -- nose pero es por ahi

delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
delayT ( Tun links ) = sum $ maps delayL links