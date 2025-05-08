Úkol 1.1
Vytvoř třídu InteractiveDoubleParsing, která obsahuje spustitelnou metodu main a opakuje donekonečna tuto činnost:

Požádá uživatele o zadání čísla.

Pokud zadal platné číslo X, které se podařilo interpretovat jako typ double, vypíše se “Zadal jste číslo X”. Pokud zadá neplatný řetězec (např “ABC”), vypíše se “Zadal jste neplatný řetězec ABC”.

Úkol 1.2
Vytvoř třídu InteractiveFractionParsing, která je opět spustitelná a dělá obdobnou činnost, ale pokouší se vstup zpracovat pomocí metody Fraction.parse, na které pracujeme ve společné části projektu na cvikách 3 až 4.
Pokud je zadáno např. “1/6 + 1/3”, vypíše se “Zadal jste zlomek 1/2”. Pokud je zadán neplatný řetězec (např “ABC”), vypíše se “Zadal jste neplatný řetězec ABC”.

Úkol 1.3
Společná část po cvikách 3 až 4 obsahuje potřebnou logiku na načtení dat do paměti, včetně potřebného parsování. Takto načtená data už je možné exportovat do potřebného formátu. Doplň program tak, aby vytvářel CSV soubory ve složce C:/data/output, které budou odpovídat 1:1 stupním souborům, ale oddělovač bude vždy čárka a číselná hodnota bude ve zpracované podobě (zlomky v základním tvaru a bez sčítání).
Vaše výstupní soubory můžete porovnat se správnými: refOutput.zip. Kdo si chce být jistý, může na konci programu ověřit správnost všech výstupů automaticky.
