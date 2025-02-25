2. Er gildið á in sem prentað er út það sama og búist var við? Hvernig sést að um kapphlaup (race condition) sé að ræða?
Nei, gildið er oft lægra en 2× iterationsPerThread.
Þetta sést vegna þess að þegar hvor þráður fyrir sig keyrir lykkju til að auka gildið á in, geta þeir lesið sömu tölu á sama tíma, hækkað hana, og síðan skrifað aftur, þannig að ein uppfærsla tapast. Þar af leiðandi endar uppsafnað gildi in stundum mun lægra en búist var við.
3. Hvaða gildum er best að nota á ykkar tölvu til að sýna kapphlaupið og hvert er stýrikerfið?
Með 1 000 000 ítrunum (e. iterations) hjá hvorum þræði hefur reyndin verið að niðurstaðan sé oft nokkuð lægri en 2 000 000.
Ég keyrði kóðann á Windows 10 (eða Windows 11), og það sýnir kapphlaupið mjög greinilega nánast í hverri keyrslu (til dæmis kom útkoman stundum aðeins um 800 000–1 200 000 í stað 2 000 000).