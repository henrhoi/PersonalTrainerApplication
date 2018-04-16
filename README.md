# PT-applikasjon - Gruppe 01
Vi er 7 studenter på NTNU som våren 2018 har gjennomført et prosjekt i emnet TDT4140 - Programvareutvikling. Prosjektet gikk ut på å lage en trelags klientapplikasjon skrevet i Java og JavaFX/FXML, der data skulle kunne tas i mot utenifra over en standard nettverksprotokoll.
Vi har fulgt den smidige utviklingsmetoden *Scrum*, som du kan lese mer om [her](http://www.mountaingoatsoftware.com/agile/scrum).
Alle kravene til prosjektet som spesifisert av emnet finner du her [her](https://gitlab.stud.iie.ntnu.no/tdt4140-2018/01/wikis/Home/Prosjektkrav).
I tillegg har utviklingen fulgt kodekonvensjonene og retningslinjene for bruk av GitLab som finnes [her](https://gitlab.stud.iie.ntnu.no/tdt4140-2018/01/wikis/Home/Kodekonvensjoner%20og%20retningslinjer%20i%20gitlab).

Vi har valgt å lage en applikasjon der en personlig trener kan følge opp sine klienter. PT-en kan navigere mellom klientene og se informasjon om utholdenhetsøkter, styrkeøkter, kosthold og treningsprogrammer. Under er en liten demo som viser applikasjonen mens den kjører.

[gif](https://imgur.com/GCzBI1P)


## Hvordan bruke applikasjonen

Disse instruksjonene gir deg en kopi av prosjektet på din lokale maskin, som du kan bruke til utvikling og/eller testing. Se [her](#start) for fremgangsmåte for å kjøre prosjektet, etter installering.



### Installering
---

For å installere systemet, kjør følgende kommando:

```
$ git clone https://gitlab.stud.iie.ntnu.no/tdt4140-2018/01.git
```

#### Få tilgang til database:

Applikasjonen har SQL-database på NTNU-servere, og for å ha tilgang på denne må man enten være tilkoblet nettverket Eduroam eller bruke et VPN-program som tillater å koble til NTNUs nettverk hjemmefra.
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
	│   	     │    ├── java.tdt4140.gr1801.app.core.pdfcreator
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

2. Kjør `FxApp.java` i `/tdt4140.gr1801.app.ui/src/main/java/tdt4140/gr1801/app/ui`




Det finnes en **DEMO-bruker** med fiktiv data, for å få en innsikt av hvordan applikasjonen fungerer i praksis:

````
username: demo
password: puerbest
```




<br></br>
## Utviklet med

* [Eclipse Oxygen](https://www.eclipse.org/) - Utviklingsverktøy - IDE
* [Maven](https://maven.apache.org/) - Håndtering av avhengigheter
* [Jetty](https://www.eclipse.org/jetty/)
* [Jersey](https://jersey.github.io/)
* [JSON](https://stleary.github.io/JSON-java/)


<br></br>
## Forfattere

* **Vilde Arntzen** - *Scrum Master*
* **Sebastian Øveraas** - *Utvikler*
* **Henrik Høiness** - *Utvikler*
* **Axel Harstad** - *Utvikler*
* **Kristoffer Gjerde** - *Utvikler*
* **Emilie Dahl** - *Utvikler*
* **Martin Johansen** - *Utvikler*

