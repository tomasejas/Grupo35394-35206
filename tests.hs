import quality
import point
import city
import link
import tunel
import region

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