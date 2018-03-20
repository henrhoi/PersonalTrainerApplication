# PT-applikasjon - Gruppe 01

Vi har laget en applikasjon der en PT kan følge sine klienter. PT-en kan se følgende informasjon om sine 

## Hvordan bruke applikasjonen

Disse instruksjonene gir deg en kopi av prosjektet oppe og går på din lokale maskin for utvikling og testing. Se [her](#start) for fremgangsmåte for å kjøre prosjektet, etter installering.



### Installering
---

For å installere systemet, kjør følgende kommando

```
$ git clone https://gitlab.stud.iie.ntnu.no/tdt4140-2018/01.git
```

#### Få tilgang til database:

Applikasjonen har SQL-database på NTNU-servere, og for å ha tilgang på denne må man enten være tilkoblet Eduroam eller bruke VPN-program som tillater å koble til NTNUs nettverk hjemmefra.
Vi har brukt VPN-programvaren som tilbys av NTNU [her](https://software.ntnu.no/ntnu/vpn), kalt *Cisco AnyConnect*. Følg installasjonsbeskrivelsen som står på nedlastingssiden.


#### Importere i Eclipse
For å få prosjektet vårt opp i *Eclipse* på samme måte som vi har kan du følge denne fremgangsmåten:

![ImportereiEclipse](https://i.imgur.com/UIlAxUa.png)

1. Åpne Eclipse. 

2. Trykk på **File**, deretter **Import...**.


3. Velg *General* > *Excisting Projects into Workspace*

	
4. Velg *Root directoriet*: **01** og klikk **Open**. Huk av *Search for nested projects*. Trykk så *Select all*, slik at alle de nestede prosjektene er huket av. 


5. Trykk så **Next**/**Finish**. Repositoriet skal nå være klart til å bli kodet, pushet og pullet.


<br></br>

### Generell struktur
---
	
```
tdt4140-gr1801
	│
	├─── app.core
	│   	└── src
	│   	     ├── main
	│   	     │    ├── java.tdt4140.gr1801.app.core
	│   	     │    └── resources.tdt4140.gr1801.app.core
	│   	     └── test
	│   	          ├── java.tdt4140.gr1801.app.core
	│   	          └── resources.tdt4140.gr1801.app.core
	│        
	├─── app.ui
	│   	└── src
	│   	     ├── main
	│   	     │    ├── java.tdt4140.gr1801.app.ui
	│   	     │    └── resources.tdt4140.gr1801.app.ui
	│   	     └── test
	│   	          ├── java.tdt4140.gr1801.app.ui
	│   	          └── resources.tdt4140.gr1801.app.ui
	│             
	└── web.server
	    	└── src
	    	     ├── main
	    	     │    ├── java.tdt4140.gr1801.web.server
	    	     │    └── resources.tdt4140.gr1801.web.server
	    	     └── test
	    	          ├── java.tdt4140.gr1801.web.server
	    	          └── resources.tdt4140.gr1801.web.server
```
<br></br>
<a name="start"></a>
## Kjøre applikasjonen

Her er en oversikt over hva som skal til for å få applikasjonen til å kjøre på din lokale maskin.

1. Koble til NTNUs nettverk med *Cisco AnyConnect*, dersom du allerede ikke er på Eduroam.

2. Kjør `WebServer.java` i `/tdt4140.gr1801.web.server/src/main/java/tdt4140/gr1801/web/server`

3. Kjør `FxApp.java` i `/tdt4140.gr1801.app.ui/src/main/java/tdt4140/gr1801/app/ui`




Det finnes en **DEMO-bruker** med fiktiv data, for å få en innsikt av hvordan applikasjonen fungerer i praksis:

````
username: demo
password: puerbest
```




<br></br>
## Utviklet med

* [Eclipse Oxygen](https://www.eclipse.org/) - Utviklingsverktøy - IDE
* [Maven](https://maven.apache.org/) - Håndtering av avhengigheter


<br></br>
## Forfattere

* **Vilde Arntzen** - *Scrum Master*
* **Sebastian Øveraas** - *Utvikler*
* **Henrik Høiness** - *Utvikler*
* **Axel Harstad** - *Utvikler*
* **Kristoffer Gjerde** - *Utvikler*
* **Emilie Dahl** - *Utvikler*
* **Martin Johansen** - *Utvikler*

