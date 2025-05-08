

Popis projektu
Projekt Fractions umožňuje práci se zlomky v jazyce Java. Zpracovává vstupní soubory obsahující procenta nebo zlomky, provádí jejich konverzi a ukládá výsledky do výstupních souborů. Podporuje základní operace se zlomky (sčítání, odčítání, násobení, dělení) a práci s procenty.

Struktura projektu
Projekt obsahuje složky: .idea/ (nastavení pro IntelliJ IDEA), Data/Input/ (vstupní soubory ve formátu CSV), Data/Output/ (výstupní soubory s upravenými daty) a src/main/java/pro1/ (hlavní zdrojový kód aplikace). V této složce se nacházejí třídy:

ExamRecord.java – Uchovává informace o testech, včetně jména studenta a výsledku ve formě zlomku.
Fraction.java – Třída reprezentující zlomek, podporuje operace jako sčítání, odčítání, násobení a dělení.
CSVExporter.java – Exportuje výsledné záznamy do CSV souborů.
InteractiveDoubleParse.java – Umožňuje interaktivní parsování desetinných čísel.
InteractiveFractionParse.java – Interaktivní zadávání a zpracování zlomků.
Main.java – Hlavní třída, která načítá data ze složky Data/Input, zpracovává je a ukládá do Data/Output.