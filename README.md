# webshopfinal

## Firebase autentikáció meg van valósítva:
A főoldalon (MainActivity) van megvalósítva a bejelentkezés. Regisztráció gombra kattintva átirányít a SignUpActivity-re, ahol regisztrálni lehet. Egy hibának lekezelése hiányos, erre figyelni kell: Üres input mezőknél való bejelentkezés próbálkozásnál leáll a program.

## Adatmodell definiálása (class vagy interfész formájában): 
Külön class-ban van megvalósítva az item layout és egyéb

## Legalább 3 különböző activity vagy fragmens:
Van 3 activity

## Beviteli mezők beviteli típusa megfelelő:
Mindegyik .xml kiterjesztésű fájlban megtörténik minimum az inputType beállítása

## ConstraintLayout és még egy másik layout típus használata:
activity_main.xml-ben constraint layout és linear layout, activity_sign_up-ban relative layout

## Reszponzivitás:
Többnyire meg van oldva, csakis a legkisebb kijelzőknél vélhető fel hiba
(Alapvetően 5.0" méretű kijelzőn, Pixel 2 virtuális eszközön tesztelve)

## Animációk:
2 animáció létezik, ShoppingItemAdapter osztályban található az egyik animáció megvalósítása, ez egy beúszás, tehát bejelentkezés után a webshop felületen a kártyák beúsznak. Másik animáció a login felületnél a előtűnnek az elemek

## Intentek használata (minden activity elérhető):
Mindegyik activity elérhető, intentekkel meg van oldva a navigáció

## Lifecycle hook:
A MainActivity-n belül, ha a bejelentkezésni felületnél az email címnek írunk be valamit, majd a registration gombra kattintva átírányít minket a regisztrációs felületre akkor azonnal be lesz írva az email cím ott is. Ez a MainActivity-ben az onPause() felülírásával lehetséges.

## Notification / alarm manager
Hiányos, nem működik megfelelően. Alapvetően egy termék törlésekor kellene notificationt kapni, valamint a shopping felületen való 10 másodperces időtöltés után.

## CRUD
Firestore miatt alapvetőel külön szálon van kezelve. Az olvasás meg van valósítva, az adatbázisból olvassa le az adatokat. Törlés is meg van valósítva, lehet törölni elemeket a termékek közül. Létrehozás részlegesen, előre megadott termékeket tölt fel az adatbázisba, ha az üres. (Ha mindent kitörlünk automatikusan feltölti azokat). Saját termék hozzáadására nincs lehetőség.

## Egyéb:
Shopping nézetnél a fenti menüpontoknál a keresés (szűrés) és a továbbiaknál a kijelentkezés működik. A kosárhoz adás és a kosár funkció nem működőképes, tehát vizuális elemnek tekintendő.

