import Mod link.hs

module Tunel ( Tunel, newT, connectsT, usesT, delayT )
   where

data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel
newT links_conection = Tun links_conection

connectsT :: City -> City -> Tunel -> Bool -- inidca si este tunel conceta estas dos ciudades distintas
connectsT city_1 city_2 tunel = ( connectsL city_1 link && connectsL city_2 link ) -- nose

usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link
usesT link Tun ( _ ) = link `elem` -- nose pero es por ahi

delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
delayT ( Tun (Lin _ _ ( Qua _ _ delay ) ) ) = delay -- dudoso si está bien escrito