import point.hs

module City ( City, newC, nameC, distanceC )
   where

data City = Cit String Point deriving (Eq, Show)

newC :: String -> Point -> City
newC = city_name city_point = Cit city_name city_point

nameC :: City -> String
nameC ( Cit city_name _ ) = city_name

distanceC :: City -> City -> Float
distanceC ( Cit _ city_pointA ) ( Cit _ city_pointB ) = difP city_pointA city_pointB