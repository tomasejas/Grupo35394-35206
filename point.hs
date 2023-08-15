module Point ( Point, newP, difP)
   where

data Point = Poi Int Int deriving (Eq, Show)

newP :: Int -> Int -> Point
newP x y = Poi x y

difP :: Point -> Point -> Float  -- distancia absoluta
difP ( Poi xP0 yP0 ) ( Poi xP1 yP1 ) = sqrt $ fromIntegral ( ( xP1 - xP0 ) ^ 2 + ( yP1 - yP0 ) ^ 2 )