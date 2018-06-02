# Kodekonvensjoner og retningslinjer i Gitlab:

Målet med kodekonvensjonene er å ha en entydig, ryddig og forståelig kode.



#### **Bruk av GitLab**

* Commits skal være på norsk og på formen "#ISSUENR :  commit-melding".
  * Alle commits skal være knyttet til en issue
* Lager egen Sprint_Development-branch, som merges med ´master` når sprinten er over
* Issues/Features får egne branches som skal merges med den aktuelle Sprint_Development-branchen når de er ferdige
* Alle issues skal få en closing-kommentar, når den closes.

 


<br></br>
### **1. Språk**
* **Kode** skal være skrevet på engelsk.
* **Kommentarer** må skrives på både norsk engelsk, helst uten "æøå".
* **Innrykk** skal være av formen "TAB", ikke 4 mellomrom.

<br></br>

### **2. Statements**
Det skal maksimalt være én statement per linje. 


```java
argv++;     //Slik
argv--;


argv ++; argv--; //Unngå dette
```
<br></br>

### **3. Navnkonvensjoner**

##### **Variabelnavn:** 
Skal være beskrivende variabelnavn. Eksempel:

```java
af = 500 // Sier ikke så mye om variabelen
annualFee = 500 // Forklarer mer om verdien til variabelen
```

##### **Klasser og grensesnitt:** 
Skal bestå av substantiver som begynner med store bokstaver og ellers har små bokstaver. Eksempel: 

```java
class Raster;
class ImageSprite;

interface RasterDelegate;
interface Storing;
```
##### **Metoder:** 
Skal bestå av verb. Første bokstav er alltid liten, store forbokstaver på resten av ordene, ellers små bokstaver. 

```java
run();
runFast();
getBackground();
```

<br></br>

### **4. Små funksjoner:**
Funksjoner bør være små. Blir funksjonen veldig stor, bør den muligens deles opp i flere små. Kan også være nyttig for gjenbruk av kode.


<br></br>

### **5. Brackets:**
Den første bracketen, "{", skal være på slutten av samme linje som deklarasjonen av metoden.
Den avsluttende bracketen, "}", skal være på en egen linje. Eksempel:

*Riktig*:
```java
while True{
    doSomething();
}
```


*Feil*:
```java
while True
{
    doSomething();
}
```

<br></br>

#### **6. Gi logiske operatorer plass:**
```java
// Riktig
for (int i = 0; i < 5; i++) {
    a += c + d;
}
 
// Unngå
for(int i=0;i<5;i++) {
    a+=c+d;
}
```





