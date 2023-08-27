module Tunel ( Tunel, newT, connectsT, usesT, delayT )
   where

import City
import Link

data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel
newT links = Tun links

connectsT :: City -> City -> Tunel -> Bool -- inidca si este tunel conceta estas dos ciudades distintas
connectsT city_1 city_2 (Tun links) =
    case links of
        [] -> False
        [link] -> connectsL city_1 link && connectsL city_2 link
        firstLink : _ -> connectsL city_1 firstLink && connectsL city_2 (last links)

usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link
usesT link ( Tun links ) = link `elem` links -- nose pero es por ahi

delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
delayT ( Tun links ) = sum $ map delayL links