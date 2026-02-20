# KNIGHT OF THE NINE

Textová adventura v jazyce Java.

---

## ÚVOD

Konzolová RPG textová hra vyvinutá v jazyce Java 21.

Projekt je zaměřen na objektově orientovaný návrh, oddělení herní logiky od datové konfigurace (JSON), implementaci tahového soubojového systému a využití návrhových vzorů (např. Command pattern).  

Hra je plně konfigurovatelná přes externí soubor `world.json` a obsahuje unit testy ověřující klíčové části herní mechaniky.


---

## PŘÍBĚH

Království žije ve stínu hrozby. Na obzoru se objevil drak – mocný a nebezpečný tvor, který zatím neútočí přímo, ale jeho přítomnost šíří strach mezi obyvateli.

Jsi rytíř pověřený úkolem draka zastavit. Přímý útok bez přípravy znamená téměř jistou smrt.

Svět kolem tebe skrývá nepřátele, spojence i klíčové předměty. Pouze správná příprava, vybavení a taktika ti umožní přežít finální souboj.

---

## POPIS

Knight of the Nine je konzolová textová hra, ve které se hráč ujímá role rytíře vyslaného porazit draka.

Hráč musí:

- prozkoumávat propojený svět lokací
- sbírat a používat předměty
- komunikovat s NPC postavami
- porážet nepřátele v tahových soubojích
- strategicky se připravit na finální střet

---

## CÍL HRY

Cílem hry je porazit draka.

Drak je dostupný téměř od začátku hry, ale bez přípravy je souboj extrémně nebezpečný. Úspěch závisí na:

- získání vhodného vybavení
- správném využití inventáře
- odhalení slabiny draka
- taktice v boji

---

## HERNÍ SVĚT

- Herní svět je načítán z konfiguračního souboru `world.json`
- Lokace jsou propojené světovými stranami
- Některé lokace obsahují nepřátele
- Některé lokace obsahují klíčové předměty nebo NPC
- Po poražení nepřátel se může změnit popis lokace

---

## SOUBOJ

Souboj je tahový.

Hráč může použít příkazy:

- `utok` – útok na aktuálního nepřítele
- `obrana` – snížení poškození příštího útoku
- `uhnout` – pokus o vyhnutí útoku (50%)

Nepřátelé mají vlastní chování:

- běžný útok
- nabíjený silný útok
- speciální schopnosti (např. drakův ohnivý dech)

Neúspěšný pokus o vyhnutí může vést k vyššímu poškození.

---

## INVENTÁŘ A VÝBAVA

Hráč má:

### Inventář
- Kapacita: 4 sloty
- Slouží pouze pro běžné předměty (itemy)
- Při plném inventáři nelze vzít další předmět

### Výbavu (samostatné sloty)
- Zbraň
- Zbroj
- Štít

Výbava nezabírá místo v inventáři.

Některé předměty poskytují:
- bonus k poškození
- obranu (armor)
- blokování (shield)
- speciální efekty (např. odolnost proti ohni)

---

## PŘÍKAZY

```
jdi <S|J|V|Z>
prozkoumej
vezmi <předmět>
odhodit <předmět>
pouzij <předmět>
mluv <postava>
utok
obrana
uhnout
inventar
napoveda
mapa
stav
pomoc
konec
```

---

## TECHNICKÉ INFORMACE

- Jazyk: Java 21
- Herní svět, předměty a postavy jsou načítány z JSON souboru
- Projekt využívá knihovnu Jackson pro práci s JSON

---

## SPUŠTĚNÍ

1. Vytvoř spustitelný JAR přes IDE (IntelliJ IDEA – Build Artifact).
2. Ve složce s výsledným souborem spusť:

```
java -jar KOTN.jar
```

Hra probíhá v konzoli.

---

## POŽADAVKY

- Java 21 
- Konzolové prostředí (CMD / PowerShell)

---

## STRUKTURA PROJEKTU

```
src/
 └── cz.macek.knight/
      ├── character
      ├── command
      ├── data
      ├── item
      ├── main
      └── world

resources/
 └── world.json

test/
 ├── BackpackTest
 ├── CastleRoomTest
 ├── CombatTest
 ├── EnemyDeathTest
 ├── PotionUseTest
 └── UnlockCastleTest 
```

---

## TESTOVÁNÍ

Projekt obsahuje unit testy ověřující klíčové části herní logiky:

- výpočet poškození v souboji
- práci s inventářem
- používání lektvarů
- odemykání lokací
- smrt nepřítele

Testy zajišťují stabilitu herních mechanik při úpravách kódu.

---

## AUTOR

Jakub Maček  
Studijní projekt (2025/2026)