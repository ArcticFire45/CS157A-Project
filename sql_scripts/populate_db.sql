-- CREATE TABLE Pokemon (
--     ID INT PRIMARY KEY,
--     Number INT,
--     PokeName VARCHAR(50),
--     Type1 VARCHAR(20),
--     Type2 VARCHAR(20),
--     GifURL VARCHAR(100),
--     ImageURL VARCHAR(100),
--     PokemonDescription TEXT
-- );

-- Insert data
INSERT INTO pokemontemplate (PokeTemplateID, StockPrice, PokeName, Type1, Type2, GifURL, ImageURL, PokemonDescription) VALUES
(1, 'Bulbasaur', 'Grass', 'Poison', 'https://play.pokemonshowdown.com/sprites/bwani/bulbasaur.gif', 'https://play.pokemonshowdown.com/sprites/bw/bulbasaur.png', 'A strange seed was planted on its back at birth. The plant sprouts and grows with this Pokemon.'),
(2, 'Ivysaur', 'Grass', 'Poison', 'https://play.pokemonshowdown.com/sprites/bwani/ivysaur.gif', 'https://play.pokemonshowdown.com/sprites/bw/ivysaur.png', 'Often seen swimming elegantly by lake shores. It is often mistaken for the Japanese monster, Kappa.'),
(3, 'Venusaur', 'Grass', 'Poison', 'https://play.pokemonshowdown.com/sprites/bwani/venusaur.gif', 'https://play.pokemonshowdown.com/sprites/bw/venusaur.png', 'Because it stores several kinds of toxic gases in its body, it is prone to exploding without warning.'),
(4, 'Charmander', 'Fire', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/charmander.gif', 'https://play.pokemonshowdown.com/sprites/bw/charmander.png', 'Obviously prefers hot places. When it rains, steam is said to spout from the tip of its tail.'),
(5, 'Charmeleon', 'Fire', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/charmeleon.gif', 'https://play.pokemonshowdown.com/sprites/bw/charmeleon.png', 'When it swings its burning tail, it elevates the temperature to unbearably high levels.'),
(6, 'Charizard', 'Fire', 'Flying', 'https://play.pokemonshowdown.com/sprites/bwani/charizard.gif', 'https://play.pokemonshowdown.com/sprites/bw/charizard.png', 'Spits fire that is hot enough to melt boulders. Known to cause forest fires unintentionally.'),
(7, 'Squirtle', 'Water', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/squirtle.gif', 'https://play.pokemonshowdown.com/sprites/bw/squirtle.png', 'After birth, its back swells and hardens into a shell. Powerfully sprays foam from its mouth.'),
(8, 'Wartortle', 'Water', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/wartortle.gif', 'https://play.pokemonshowdown.com/sprites/bw/wartortle.png', 'Often hides in water to stalk unwary prey. For swimming fast, it moves its ears to maintain balance.'),
(9, 'Blastoise', 'Water', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/blastoise.gif', 'https://play.pokemonshowdown.com/sprites/bw/blastoise.png', 'A brutal Pokemon with pressurized water jets on its shell. They are used for high speed tackles.'),
(10, 'Caterpie', 'Bug', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/caterpie.gif', 'https://play.pokemonshowdown.com/sprites/bw/caterpie.png', 'Its short feet are tipped with suction pads that enable it to tirelessly climb slopes and walls.'),
(11, 'Metapod', 'Bug', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/metapod.gif', 'https://play.pokemonshowdown.com/sprites/bw/metapod.png', 'This Pokemon is vulnerable to attack while its shell is soft, exposing its weak and tender body.'),
(12, 'Butterfree', 'Bug', 'Flying', 'https://play.pokemonshowdown.com/sprites/bwani/butterfree.gif', 'https://play.pokemonshowdown.com/sprites/bw/butterfree.png', 'In battle, it flaps its wings at high speed to release highly toxic dust into the air.'),
(13, 'Weedle', 'Bug', 'Poison', 'https://play.pokemonshowdown.com/sprites/bwani/weedle.gif', 'https://play.pokemonshowdown.com/sprites/bw/weedle.png', 'Often found in forests, eating leaves. It has a sharp venomous stinger on its head.'),
(14, 'Kakuna', 'Bug', 'Poison', 'https://play.pokemonshowdown.com/sprites/bwani/kakuna.gif', 'https://play.pokemonshowdown.com/sprites/bw/kakuna.png', 'Almost incapable of moving, this Pokemon can only harden its shell to protect itself from predators.'),
(15, 'Beedrill', 'Bug', 'Poison', 'https://play.pokemonshowdown.com/sprites/bwani/beedrill.gif', 'https://play.pokemonshowdown.com/sprites/bw/beedrill.png', 'Flies at high speed and attacks using its large venomous stingers on its forelegs and tail.'),
(16, 'Pidgey', 'Normal', 'Flying', 'https://play.pokemonshowdown.com/sprites/bwani/pidgey.gif', 'https://play.pokemonshowdown.com/sprites/bw/pidgey.png', 'A common sight in forests and woods. It flaps its wings at ground level to kick up blinding sand.'),
(17, 'Pidgeotto', 'Normal', 'Flying', 'https://play.pokemonshowdown.com/sprites/bwani/pidgeotto.gif', 'https://play.pokemonshowdown.com/sprites/bw/pidgeotto.png', 'Very protective of its sprawling territorial area, this Pokemon will fiercely peck at any intruder.'),
(18, 'Pidgeot', 'Normal', 'Flying', 'https://play.pokemonshowdown.com/sprites/bwani/pidgeot.gif', 'https://play.pokemonshowdown.com/sprites/bw/pidgeot.png', 'When hunting, it skims the surface of water at high speed to pick off unwary prey such as MAGIKARP.'),
(19, 'Rattata', 'Normal', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/rattata.gif', 'https://play.pokemonshowdown.com/sprites/bw/rattata.png', 'Bites anything when it attacks. Small and very quick, it is a common sight in many places.'),
(20, 'Raticate', 'Normal', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/raticate.gif', 'https://play.pokemonshowdown.com/sprites/bw/raticate.png', 'It uses its whiskers to maintain its balance. It apparently slows down if they are cut off.'),
(21, 'Spearow', 'Normal', 'Flying', 'https://play.pokemonshowdown.com/sprites/bwani/spearow.gif', 'https://play.pokemonshowdown.com/sprites/bw/spearow.png', 'Eats bugs in grassy areas. It has to flap its short wings at high speed to stay airborne.'),
(22, 'Fearow', 'Normal', 'Flying', 'https://play.pokemonshowdown.com/sprites/bwani/fearow.gif', 'https://play.pokemonshowdown.com/sprites/bw/fearow.png', 'With its huge and magnificent wings, it can keep aloft without ever having to land for rest.'),
(23, 'Ekans', 'Poison', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/ekans.gif', 'https://play.pokemonshowdown.com/sprites/bw/ekans.png', 'Moves silently and stealthily. Eats the eggs of birds, such as PIDGEY and SPEAROW, whole.'),
(24, 'Arbok', 'Poison', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/arbok.gif', 'https://play.pokemonshowdown.com/sprites/bw/arbok.png', 'It is rumored that the ferocious warning markings on its belly differ from area to area.'),
(25, 'Pikachu', 'Electric', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/pikachu.gif', 'https://play.pokemonshowdown.com/sprites/bw/pikachu.png', 'When several of these Pokemon gather, their electricity could build and cause lightning storms.'),
(26, 'Raichu', 'Electric', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/raichu.gif', 'https://play.pokemonshowdown.com/sprites/bw/raichu.png', 'Its long tail serves as a ground to protect itself from its own high voltage power.'),
(27, 'Sandshrew', 'Ground', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/sandshrew.gif', 'https://play.pokemonshowdown.com/sprites/bw/sandshrew.png', 'Burrows deep underground in arid locations far from water. It only emerges to hunt for food.'),
(28, 'Sandslash', 'Ground', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/sandslash.gif', 'https://play.pokemonshowdown.com/sprites/bw/sandslash.png', 'Curls up into a spiny ball when threatened. It can roll while curled up to attack or escape.'),
(29, 'NidoranF', 'Poison', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/nidoranf.gif', 'https://play.pokemonshowdown.com/sprites/bw/nidoranf.png', 'Although small, its venomous barbs render this Pokemon dangerous. The female has smaller horns.'),
(30, 'Nidorina', 'Poison', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/nidorina.gif', 'https://play.pokemonshowdown.com/sprites/bw/nidorina.png', 'The female''s horn develops slowly. Prefers physical attacks such as clawing and biting.'),
(31, 'Nidoqueen', 'Poison', 'Ground', 'https://play.pokemonshowdown.com/sprites/bwani/nidoqueen.gif', 'https://play.pokemonshowdown.com/sprites/bw/nidoqueen.png', 'Its hard scales provide strong protection. It uses its hefty bulk to execute powerful moves.'),
(32, 'NidoranM', 'Poison', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/nidoranm.gif', 'https://play.pokemonshowdown.com/sprites/bw/nidoranm.png', 'Stiffens its ears to sense danger. The larger its horns, the more powerful its secreted venom.'),
(33, 'Nidorino', 'Poison', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/nidorino.gif', 'https://play.pokemonshowdown.com/sprites/bw/nidorino.png', 'An aggressive Pokemon that is quick to attack. The horn on its head secretes a powerful venom.'),
(34, 'Nidoking', 'Poison', 'Ground', 'https://play.pokemonshowdown.com/sprites/bwani/nidoking.gif', 'https://play.pokemonshowdown.com/sprites/bw/nidoking.png', 'It uses its powerful tail in battle to smash, constrict, then break the prey''s bones.'),
(35, 'Clefairy', 'Normal', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/clefairy.gif', 'https://play.pokemonshowdown.com/sprites/bw/clefairy.png', 'Its magical and cute appeal has many admirers. It is rare and found only in certain areas.'),
(36, 'Clefable', 'Normal', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/clefable.gif', 'https://play.pokemonshowdown.com/sprites/bw/clefable.png', 'A timid fairy Pokemon that is rarely seen. It will run and hide the moment it senses people.'),
(37, 'Vulpix', 'Fire', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/vulpix.gif', 'https://play.pokemonshowdown.com/sprites/bw/vulpix.png', 'At the time of birth, it has just one tail. The tail splits from its tip as it grows older.'),
(38, 'Ninetales', 'Fire', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/ninetales.gif', 'https://play.pokemonshowdown.com/sprites/bw/ninetales.png', 'Very smart and very vengeful. Grabbing one of its many tails could result in a 1000-year curse.'),
(39, 'Jigglypuff', 'Normal', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/jigglypuff.gif', 'https://play.pokemonshowdown.com/sprites/bw/jigglypuff.png', 'When its huge eyes light up, it sings a mysteriously soothing melody that lulls its enemies to sleep.'),
(40, 'Wigglytuff', 'Normal', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/wigglytuff.gif', 'https://play.pokemonshowdown.com/sprites/bw/wigglytuff.png', 'The body is soft and rubbery. When angered, it will suck in air and inflate itself to an enormous size.'),
(41, 'Zubat', 'Poison', 'Flying', 'https://play.pokemonshowdown.com/sprites/bwani/zubat.gif', 'https://play.pokemonshowdown.com/sprites/bw/zubat.png', 'Forms colonies in perpetually dark places. Uses ultrasonic waves to identify and approach targets.'),
(42, 'Golbat', 'Poison', 'Flying', 'https://play.pokemonshowdown.com/sprites/bwani/golbat.gif', 'https://play.pokemonshowdown.com/sprites/bw/golbat.png', 'Once it strikes, it will not stop draining energy from the victim even if it gets too heavy to fly.'),
(43, 'Oddish', 'Grass', 'Poison', 'https://play.pokemonshowdown.com/sprites/bwani/oddish.gif', 'https://play.pokemonshowdown.com/sprites/bw/oddish.png', 'During the day, it keeps its face buried in the ground. At night, it wanders around sowing its seeds.'),
(44, 'Gloom', 'Grass', 'Poison', 'https://play.pokemonshowdown.com/sprites/bwani/gloom.gif', 'https://play.pokemonshowdown.com/sprites/bw/gloom.png', 'The fluid that oozes from its mouth isn''t drool. It is a nectar that is used to attract prey.'),
(45, 'Vileplume', 'Grass', 'Poison', 'https://play.pokemonshowdown.com/sprites/bwani/vileplume.gif', 'https://play.pokemonshowdown.com/sprites/bw/vileplume.png', 'The larger its petals, the more toxic pollen it contains. Its big head is heavy and hard to hold up.'),
(46, 'Paras', 'Bug', 'Grass', 'https://play.pokemonshowdown.com/sprites/bwani/paras.gif', 'https://play.pokemonshowdown.com/sprites/bw/paras.png', 'Burrows to suck tree roots. The mushrooms on its back grow by drawing nutrients from the bug host.'),
(47, 'Parasect', 'Bug', 'Grass', 'https://play.pokemonshowdown.com/sprites/bwani/parasect.gif', 'https://play.pokemonshowdown.com/sprites/bw/parasect.png', 'A host-parasite pair in which the parasite mushroom has taken over the host bug. Prefers damp places.'),
(48, 'Venonat', 'Bug', 'Poison', 'https://play.pokemonshowdown.com/sprites/bwani/venonat.gif', 'https://play.pokemonshowdown.com/sprites/bw/venonat.png', 'Lives in the shadows of tall trees where it eats insects. It is attracted by light at night.'),
(49, 'Venomoth', 'Bug', 'Poison', 'https://play.pokemonshowdown.com/sprites/bwani/venomoth.gif', 'https://play.pokemonshowdown.com/sprites/bw/venomoth.png', 'The dust-like scales covering its wings are color coded to indicate the kinds of poison it has.'),
(50, 'Diglett', 'Ground', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/diglett.gif', 'https://play.pokemonshowdown.com/sprites/bw/diglett.png', 'Lives about one yard underground where it feeds on plant roots. It sometimes appears above ground.'),
(51, 'Dugtrio', 'Ground', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/dugtrio.gif', 'https://play.pokemonshowdown.com/sprites/bw/dugtrio.png', 'A team of DIGLETT triplets. It triggers huge earthquakes by burrowing 60 miles underground.'),
(52, 'Meowth', 'Normal', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/meowth.gif', 'https://play.pokemonshowdown.com/sprites/bw/meowth.png', 'Adores circular objects. Wanders the streets on a nightly basis to look for dropped loose change.'),
(53, 'Persian', 'Normal', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/persian.gif', 'https://play.pokemonshowdown.com/sprites/bw/persian.png', 'Although its fur has many admirers, it is tough to raise as a pet because of its fickle meanness.'),
(54, 'Psyduck', 'Water', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/psyduck.gif', 'https://play.pokemonshowdown.com/sprites/bw/psyduck.png', 'While lulling its enemies with its vacant look, this wily Pokemon will use psychokinetic powers.'),
(55, 'Golduck', 'Water', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/golduck.gif', 'https://play.pokemonshowdown.com/sprites/bw/golduck.png', 'Often seen swimming elegantly by lake shores. It is often mistaken for the Japanese monster, Kappa.'),
(56, 'Mankey', 'Fighting', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/mankey.gif', 'https://play.pokemonshowdown.com/sprites/bw/mankey.png', 'Extremely quick to anger. It could be docile one moment then thrashing away the next instant.'),
(57, 'Primeape', 'Fighting', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/primeape.gif', 'https://play.pokemonshowdown.com/sprites/bw/primeape.png', 'Always furious and tenacious to boot. It will not abandon chasing its quarry until it is caught.'),
(58, 'Growlithe', 'Fire', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/growlithe.gif', 'https://play.pokemonshowdown.com/sprites/bw/growlithe.png', 'Very protective of its territory. It will bark and bite to repel intruders from its space.'),
(59, 'Arcanine', 'Fire', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/arcanine.gif', 'https://play.pokemonshowdown.com/sprites/bw/arcanine.png', 'A Pokemon that has been admired since the past for its beauty. It runs agilely as if on wings.'),
(60, 'Poliwag', 'Water', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/poliwag.gif', 'https://play.pokemonshowdown.com/sprites/bw/poliwag.png', 'Its newly grown legs prevent it from running. It appears to prefer swimming than trying to stand.'),
(61, 'Poliwhirl', 'Water', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/poliwhirl.gif', 'https://play.pokemonshowdown.com/sprites/bw/poliwhirl.png', 'Capable of living in or out of water. When out of water, it sweats to keep its body slimy.'),
(62, 'Poliwrath', 'Water', 'Fighting', 'https://play.pokemonshowdown.com/sprites/bwani/poliwrath.gif', 'https://play.pokemonshowdown.com/sprites/bw/poliwrath.png', 'An adept swimmer at both the front crawl and breast stroke. Easily overtakes the best human swimmers.'),
(63, 'Abra', 'Psychic', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/abra.gif', 'https://play.pokemonshowdown.com/sprites/bw/abra.png', 'Using its ability to read minds, it will identify impending danger and TELEPORT to safety.'),
(64, 'Kadabra', 'Psychic', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/kadabra.gif', 'https://play.pokemonshowdown.com/sprites/bw/kadabra.png', 'It emits special alpha waves from its body that induce headaches just by being close by.'),
(65, 'Alakazam', 'Psychic', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/alakazam.gif', 'https://play.pokemonshowdown.com/sprites/bw/alakazam.png', 'Its brain can outperform a supercomputer. Its intelligence quotient is said to be 5,000.'),
(66, 'Machop', 'Fighting', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/machop.gif', 'https://play.pokemonshowdown.com/sprites/bw/machop.png', 'Loves to build its muscles. It trains in all styles of martial arts to become even stronger.'),
(67, 'Machoke', 'Fighting', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/machoke.gif', 'https://play.pokemonshowdown.com/sprites/bw/machoke.png', 'Its muscular body is so powerful, it must wear a power save belt to be able to regulate its motions.'),
(68, 'Machamp', 'Fighting', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/machamp.gif', 'https://play.pokemonshowdown.com/sprites/bw/machamp.png', 'Using its heavy muscles, it throws powerful punches that can send the victim clear over the horizon.'),
(69, 'Bellsprout', 'Grass', 'Poison', 'https://play.pokemonshowdown.com/sprites/bwani/bellsprout.gif', 'https://play.pokemonshowdown.com/sprites/bw/bellsprout.png', 'A carnivorous Pokemon that traps and eats bugs. It uses its root feet to soak up needed moisture.'),
(70, 'Weepinbell', 'Grass', 'Poison', 'https://play.pokemonshowdown.com/sprites/bwani/weepinbell.gif', 'https://play.pokemonshowdown.com/sprites/bw/weepinbell.png', 'It spits out POISONPOWDER to immobilize the enemy and then finishes it with a spray of ACID.'),
(71, 'Victreebel', 'Grass', 'Poison', 'https://play.pokemonshowdown.com/sprites/bwani/victreebel.gif', 'https://play.pokemonshowdown.com/sprites/bw/victreebel.png', 'Said to live in huge colonies deep in jungles, although no one has ever returned from there.'),
(72, 'Tentacool', 'Water', 'Poison', 'https://play.pokemonshowdown.com/sprites/bwani/tentacool.gif', 'https://play.pokemonshowdown.com/sprites/bw/tentacool.png', 'Drifts in shallow seas. Anglers who hook them by accident are often punished by its stinging acid.'),
(73, 'Tentacruel', 'Water', 'Poison', 'https://play.pokemonshowdown.com/sprites/bwani/tentacruel.gif', 'https://play.pokemonshowdown.com/sprites/bw/tentacruel.png', 'The tentacles are normally kept short. On hunts, they are extended to ensnare and immobilize prey.'),
(74, 'Geodude', 'Rock', 'Ground', 'https://play.pokemonshowdown.com/sprites/bwani/geodude.gif', 'https://play.pokemonshowdown.com/sprites/bw/geodude.png', 'Found in fields and mountains. Mistaking them for boulders, people often step or trip on them.'),
(75, 'Graveler', 'Rock', 'Ground', 'https://play.pokemonshowdown.com/sprites/bwani/graveler.gif', 'https://play.pokemonshowdown.com/sprites/bw/graveler.png', 'Rolls down slopes to move. It rolls over any obstacle without slowing or changing its direction.'),
(76, 'Golem', 'Rock', 'Ground', 'https://play.pokemonshowdown.com/sprites/bwani/golem.gif', 'https://play.pokemonshowdown.com/sprites/bw/golem.png', 'Its boulder-like body is extremely hard. It can easily withstand dynamite blasts without damage.'),
(77, 'Ponyta', 'Fire', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/ponyta.gif', 'https://play.pokemonshowdown.com/sprites/bw/ponyta.png', 'Its hooves are 10 times harder than diamonds. It can trample anything completely flat in little time.'),
(78, 'Rapidash', 'Fire', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/rapidash.gif', 'https://play.pokemonshowdown.com/sprites/bw/rapidash.png', 'Very competitive, this Pokemon will chase anything that moves fast in the hopes of racing it.'),
(79, 'Slowpoke', 'Water', 'Psychic', 'https://play.pokemonshowdown.com/sprites/bwani/slowpoke.gif', 'https://play.pokemonshowdown.com/sprites/bw/slowpoke.png', 'Incredibly slow and dopey. It takes 5 seconds for it to feel pain when under attack.'),
(80, 'Slowbro', 'Water', 'Psychic', 'https://play.pokemonshowdown.com/sprites/bwani/slowbro.gif', 'https://play.pokemonshowdown.com/sprites/bw/slowbro.png', 'The SHELLDER that is latched onto SLOWPOKE\'s tail is said to feed on the host\'s left over scraps.'),
(81, 'Magnemite', 'Electric', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/magnemite.gif', 'https://play.pokemonshowdown.com/sprites/bw/magnemite.png', 'Uses anti-gravity to stay suspended. Appears without warning and uses THUNDER WAVE and similar moves.'),
(82, 'Magneton', 'Electric', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/magneton.gif', 'https://play.pokemonshowdown.com/sprites/bw/magneton.png', 'Formed by several MAGNEMITEs linked together. They frequently appear when sunspots flare up.'),
(83, 'Farfetch\'d', 'Normal', 'Flying', 'http://play.pokemonshowdown.com/sprites/bwani/farfetchd.gif', 'https://play.pokemonshowdown.com/sprites/bw/farfetchd.png', 'The sprig of green onions it holds is its weapon. It is used much like a metal sword.'),
(84, 'Doduo', 'Normal', 'Flying', 'https://play.pokemonshowdown.com/sprites/bwani/doduo.gif', 'https://play.pokemonshowdown.com/sprites/bw/doduo.png', 'A bird that makes up for its poor flying with its fast foot speed. Leaves giant footprints.'),
(85, 'Dodrio', 'Normal', 'Flying', 'https://play.pokemonshowdown.com/sprites/bwani/dodrio.gif', 'https://play.pokemonshowdown.com/sprites/bw/dodrio.png', 'Uses its three brains to execute complex plans. While two heads sleep, one head stays awake.'),
(86, 'Seel', 'Water', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/seel.gif', 'https://play.pokemonshowdown.com/sprites/bw/seel.png', 'The protruding horn on its head is very hard. It is used for bashing through thick ice.'),
(87, 'Dewgong', 'Water', 'Ice', 'https://play.pokemonshowdown.com/sprites/bwani/dewgong.gif', 'https://play.pokemonshowdown.com/sprites/bw/dewgong.png', 'Stores thermal energy in its body. Swims at a steady 8 knots even in intensely cold waters.'),
(88, 'Grimer', 'Poison', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/grimer.gif', 'https://play.pokemonshowdown.com/sprites/bw/grimer.png', 'Sludge exposed to X-rays from the moon transformed into Grimer. It loves feeding on filthy things.'),
(89, 'Muk', 'Poison', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/muk.gif', 'https://play.pokemonshowdown.com/sprites/bw/muk.png', 'Thickly covered with a filthy, vile sludge. It is so toxic, even its footprints contain poison.'),
(90, 'Shellder', 'Water', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/shellder.gif', 'https://play.pokemonshowdown.com/sprites/bw/shellder.png', 'Its hard shell repels any kind of attack. It is vulnerable only when its shell is open.'),
(91, 'Cloyster', 'Water', 'Ice', 'https://play.pokemonshowdown.com/sprites/bwani/cloyster.gif', 'https://play.pokemonshowdown.com/sprites/bw/cloyster.png', 'When attacked, it launches its horns in quick volleys. Its innards have never been seen.'),
(92, 'Gastly', 'Ghost', 'Poison', 'https://play.pokemonshowdown.com/sprites/bwani/gastly.gif', 'https://play.pokemonshowdown.com/sprites/bw/gastly.png', 'Almost invisible, this gaseous Pokemon cloaks the target and puts it to sleep without notice.'),
(93, 'Haunter', 'Ghost', 'Poison', 'https://play.pokemonshowdown.com/sprites/bwani/haunter.gif', 'https://play.pokemonshowdown.com/sprites/bw/haunter.png', 'Because of its ability to slip through block walls, it is said to be from another dimension.'),
(94, 'Gengar', 'Ghost', 'Poison', 'https://play.pokemonshowdown.com/sprites/bwani/gengar.gif', 'https://play.pokemonshowdown.com/sprites/bw/gengar.png', 'Under a full moon, this Pokemon likes to mimic the shadows of people and laugh at their fright.'),
(95, 'Onix', 'Rock', 'Ground', 'https://play.pokemonshowdown.com/sprites/bwani/onix.gif', 'https://play.pokemonshowdown.com/sprites/bw/onix.png', 'As it digs through the ground, it absorbs many hard objects. This is what makes its body so solid.'),
(96, 'Drowzee', 'Psychic', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/drowzee.gif', 'https://play.pokemonshowdown.com/sprites/bw/drowzee.png', 'Puts enemies to sleep then eats their dreams. Occasionally gets sick from eating bad dreams.'),
(97, 'Hypno', 'Psychic', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/hypno.gif', 'https://play.pokemonshowdown.com/sprites/bw/hypno.png', 'When it locks eyes with an enemy, it will use a mix of PSI moves such as HYPNOSIS and CONFUSION.'),
(98, 'Krabby', 'Water', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/krabby.gif', 'https://play.pokemonshowdown.com/sprites/bw/krabby.png', 'Its pincers are not only powerful weapons, they are used for balance when walking sideways.'),
(99, 'Kingler', 'Water', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/kingler.gif', 'https://play.pokemonshowdown.com/sprites/bw/kingler.png', 'The large pincer has 10,000-horsepower strength. However, its huge size makes it unwieldy to use.'),
(100, 'Voltorb', 'Electric', NULL, 'https://play.pokemonshowdown.com/sprites/bwani/voltorb.gif', 'https://play.pokemonshowdown.com/sprites/bw/voltorb.png', 'Usually found in power plants. Easily mistaken for a POKé BALL, it has zapped many people.'),
(101,'Electrode','Electric',NULL,'https://play.pokemonshowdown.com/sprites/bwani/electrode.gif','https://play.pokemonshowdown.com/sprites/bw/electrode.png','It stores electric energy under very high pressure. It often explodes with little or no provocation.'),
(102,'Exeggcute','Grass','Psychic','https://play.pokemonshowdown.com/sprites/bwani/exeggcute.gif','https://play.pokemonshowdown.com/sprites/bw/exeggcute.png',"Often mistaken for eggs. When disturbed, they quickly gather and attack in swarms."),
(103,'Exeggutor','Grass','Psychic','https://play.pokemonshowdown.com/sprites/bwani/exeggutor.gif','https://play.pokemonshowdown.com/sprites/bw/exeggutor.png',"Legend has it that on rare occasions, one of its heads will drop off and continue on as an EXEGGCUTE."),
(104,'Cubone','Ground',NULL,'https://play.pokemonshowdown.com/sprites/bwani/cubone.gif','https://play.pokemonshowdown.com/sprites/bw/cubone.png',"Because it never removes its skull helmet, no one has ever seen this Pokemon's real face."),
(105,'Marowak','Ground',NULL,'https://play.pokemonshowdown.com/sprites/bwani/marowak.gif','https://play.pokemonshowdown.com/sprites/bw/marowak.png','The bone it holds is its key weapon. It throws the bone skillfully like a boomerang to KO targets.'),
(106,'Hitmonlee','Fighting',NULL,'https://play.pokemonshowdown.com/sprites/bwani/hitmonlee.gif','https://play.pokemonshowdown.com/sprites/bw/hitmonlee.png',"When in a hurry, its legs lengthen progressively. It runs smoothly with extra long, loping strides."),
(107,'Hitmonchan','Fighting',NULL,'https://play.pokemonshowdown.com/sprites/bwani/hitmonchan.gif','https://play.pokemonshowdown.com/sprites/bw/hitmonchan.png',"While apparently doing nothing, it fires punches in lightning fast volleys that are impossible to see."),
(108,'Lickitung','Normal',NULL,'https://play.pokemonshowdown.com/sprites/bwani/lickitung.gif','https://play.pokemonshowdown.com/sprites/bw/lickitung.png','Its tongue can be extended like a chameleon\'s. It leaves a tingling sensation when it licks enemies.'),
(109,'Koffing','Poison',NULL,'https://play.pokemonshowdown.com/sprites/bwani/koffing.gif','https://play.pokemonshowdown.com/sprites/bw/koffing.png',"Because it stores several kinds of toxic gases in its body, it is prone to exploding without warning."),
(110,'Weezing','Poison',NULL,'https://play.pokemonshowdown.com/sprites/bwani/weezing.gif','https://play.pokemonshowdown.com/sprites/bw/weezing.png',"Where two kinds of poison gases meet, 2 KOFFINGs can fuse into a WEEZING over many years."),
(111,'Rhyhorn','Ground','Rock','https://play.pokemonshowdown.com/sprites/bwani/rhyhorn.gif','https://play.pokemonshowdown.com/sprites/bw/rhyhorn.png','Its massive bones are 1000 times harder than human bones. It can easily knock a trailer flying.'),
(112,'Rhydon','Ground','Rock','https://play.pokemonshowdown.com/sprites/bwani/rhydon.gif','https://play.pokemonshowdown.com/sprites/bw/rhydon.png',"Protected by an armor-like hide, it is capable of living in molten lava of 3,600 degrees."),
(113,'Chansey','Normal',NULL,'https://play.pokemonshowdown.com/sprites/bwani/chansey.gif','https://play.pokemonshowdown.com/sprites/bw/chansey.png','A rare and elusive Pokemon that is said to bring happiness to those who manage to get it.'),
(114,'Tangela','Grass',NULL,'https://play.pokemonshowdown.com/sprites/bwani/tangela.gif','https://play.pokemonshowdown.com/sprites/bw/tangela.png','The whole body is swathed with wide vines that are similar to seaweed. Its vines shake as it walks.'),
(115,'Kangaskhan','Normal',NULL,'https://play.pokemonshowdown.com/sprites/bwani/kangaskhan.gif','https://play.pokemonshowdown.com/sprites/bw/kangaskhan.png','The infant rarely ventures out of its mother\'s protective pouch until it is 3 years old.'),
(116,'Horsea','Water',NULL,'https://play.pokemonshowdown.com/sprites/bwani/horsea.gif','https://play.pokemonshowdown.com/sprites/bw/horsea.png','Known to shoot down flying bugs with precision blasts of ink from the surface of the water.'),
(117,'Seadra','Water',NULL,'https://play.pokemonshowdown.com/sprites/bwani/seadra.gif','https://play.pokemonshowdown.com/sprites/bw/seadra.png','Capable of swimming backwards by rapidly flapping its wing-like pectoral fins and stout tail.'),
(118,'Goldeen','Water',NULL,'https://play.pokemonshowdown.com/sprites/bwani/goldeen.gif','https://play.pokemonshowdown.com/sprites/bw/goldeen.png',"Its tail fin billows like an elegant ballroom dress, giving it the nickname of the Water Queen."),
(119,'Seaking','Water',NULL,'https://play.pokemonshowdown.com/sprites/bwani/seaking.gif','https://play.pokemonshowdown.com/sprites/bw/seaking.png',"In the autumn spawning season, they can be seen swimming powerfully up rivers and creeks."),
(120,'Staryu','Water',NULL,'https://play.pokemonshowdown.com/sprites/bwani/staryu.gif','https://play.pokemonshowdown.com/sprites/bw/staryu.png','An enigmatic Pokemon that can effortlessly regenerate any appendage it loses in battle.'),
(121,'Starmie','Water','Psychic','https://play.pokemonshowdown.com/sprites/bwani/starmie.gif','https://play.pokemonshowdown.com/sprites/bw/starmie.png','Its central core glows with the seven colors of the rainbow. Some people value the core as a gem.'),
(122,'Mr. Mime','Psychic',NULL,'http://play.pokemonshowdown.com/sprites/bwani/mrmime.gif','https://play.pokemonshowdown.com/sprites/bw/mrmime.png',"If interrupted while it is miming, it will slap around the offender with its broad hands."),
(123,'Scyther','Bug','Flying','https://play.pokemonshowdown.com/sprites/bwani/scyther.gif','https://play.pokemonshowdown.com/sprites/bw/scyther.png',"With ninja-like agility and speed, it can create the illusion that there is more than one."),
(124,'Jynx','Ice','Psychic','https://play.pokemonshowdown.com/sprites/bwani/jynx.gif','https://play.pokemonshowdown.com/sprites/bw/jynx.png','It seductively wiggles its hips as it walks. It can cause people to dance in unison with it.'),
(125,'Electabuzz','Electric',NULL,'https://play.pokemonshowdown.com/sprites/bwani/electabuzz.gif','https://play.pokemonshowdown.com/sprites/bw/electabuzz.png',"Normally found near power plants, they can wander away and cause major blackouts in cities."),
(126,'Magmar','Fire',NULL,'https://play.pokemonshowdown.com/sprites/bwani/magmar.gif','https://play.pokemonshowdown.com/sprites/bw/magmar.png','Its body always burns with an orange glow that enables it to hide perfectly among flames.'),
(127,'Pinsir','Bug',NULL,'https://play.pokemonshowdown.com/sprites/bwani/pinsir.gif','https://play.pokemonshowdown.com/sprites/bw/pinsir.png',"If it fails to crush the victim in its pincers, it will swing it around and toss it hard."),
(128,'Tauros','Normal',NULL,'https://play.pokemonshowdown.com/sprites/bwani/tauros.gif','https://play.pokemonshowdown.com/sprites/bw/tauros.png',"When it targets an enemy, it charges furiously while whipping its body with its long tails."),
(129,'Magikarp','Water',NULL,'https://play.pokemonshowdown.com/sprites/bwani/magikarp.gif','https://play.pokemonshowdown.com/sprites/bw/magikarp.png',"In the distant past, it was somewhat stronger than the horribly weak descendants that exist today."),
(130,'Gyarados','Water','Flying','https://play.pokemonshowdown.com/sprites/bwani/gyarados.gif','https://play.pokemonshowdown.com/sprites/bw/gyarados.png',"Rarely seen in the wild. Huge and vicious, it is capable of destroying entire cities in a rage."),
(131,'Lapras','Water','Ice','https://play.pokemonshowdown.com/sprites/bwani/lapras.gif','https://play.pokemonshowdown.com/sprites/bw/lapras.png','A Pokemon that has been overhunted almost to extinction. It can ferry people across the water.'),
(132,'Ditto','Normal',NULL,'https://play.pokemonshowdown.com/sprites/bwani/ditto.gif','https://play.pokemonshowdown.com/sprites/bw/ditto.png','Capable of copying an enemy\'s genetic code to instantly transform itself into a duplicate of the enemy.'),
(133,'Eevee','Normal',NULL,'https://play.pokemonshowdown.com/sprites/bwani/eevee.gif','https://play.pokemonshowdown.com/sprites/bw/eevee.png','Its genetic code is irregular. It may mutate if it is exposed to radiation from element STONEs.'),
(134,'Vaporeon','Water',NULL,'https://play.pokemonshowdown.com/sprites/bwani/vaporeon.gif','https://play.pokemonshowdown.com/sprites/bw/vaporeon.png','Lives close to water. Its long tail is ridged with a fin which is often mistaken for a mermaid\'s.'),
(135,'Jolteon','Electric',NULL,'https://play.pokemonshowdown.com/sprites/bwani/jolteon.gif','https://play.pokemonshowdown.com/sprites/bw/jolteon.png','It accumulates negative ions in the atmosphere to blast out 10000- volt lightning bolts.'),
(136,'Flareon','Fire',NULL,'https://play.pokemonshowdown.com/sprites/bwani/flareon.gif','https://play.pokemonshowdown.com/sprites/bw/flareon.png',"When storing thermal energy in its body, its temperature could soar to over 1600 degrees."),
(137,'Porygon','Normal',NULL,'https://play.pokemonshowdown.com/sprites/bwani/porygon.gif','https://play.pokemonshowdown.com/sprites/bw/porygon.png','A Pokemon that consists entirely of programming code. Capable of moving freely in cyberspace.'),
(138,'Omanyte','Rock','Water','https://play.pokemonshowdown.com/sprites/bwani/omanyte.gif','https://play.pokemonshowdown.com/sprites/bw/omanyte.png',"Although long extinct, in rare cases, it can be genetically resurrected from fossils."),
(139,'Omastar','Rock','Water','https://play.pokemonshowdown.com/sprites/bwani/omastar.gif','https://play.pokemonshowdown.com/sprites/bw/omastar.png','A prehistoric Pokemon that died out when its heavy shell made it impossible to catch prey.'),
(140,'Kabuto','Rock','Water','https://play.pokemonshowdown.com/sprites/bwani/kabuto.gif','https://play.pokemonshowdown.com/sprites/bw/kabuto.png','A Pokemon that was resurrected from a fossil found in what was once the ocean floor eons ago.'),
(141,'Kabutops','Rock','Water','https://play.pokemonshowdown.com/sprites/bwani/kabutops.gif','https://play.pokemonshowdown.com/sprites/bw/kabutops.png','Its sleek shape is perfect for swimming. It slashes prey with its claws and drains the body fluids.'),
(142,'Aerodactyl','Rock','Flying','https://play.pokemonshowdown.com/sprites/bwani/aerodactyl.gif','https://play.pokemonshowdown.com/sprites/bw/aerodactyl.png',"A ferocious, prehistoric Pokemon that goes for the enemy\'s throat with its serrated saw-like fangs."),
(143,'Snorlax','Normal',NULL,'https://play.pokemonshowdown.com/sprites/bwani/snorlax.gif','https://play.pokemonshowdown.com/sprites/bw/snorlax.png',"Very lazy. Just eats and sleeps. As its rotund bulk builds, it becomes steadily more slothful."),
(144,'Articuno','Ice','Flying','https://play.pokemonshowdown.com/sprites/bwani/articuno.gif','https://play.pokemonshowdown.com/sprites/bw/articuno.png','A legendary bird Pokemon that is said to appear to doomed people who are lost in icy mountains.'),
(145,'Zapdos','Electric','Flying','https://play.pokemonshowdown.com/sprites/bwani/zapdos.gif','https://play.pokemonshowdown.com/sprites/bw/zapdos.png','A legendary bird Pokemon that is said to appear from clouds while dropping enormous lightning bolts.'),
(146,'Moltres','Fire','Flying','https://play.pokemonshowdown.com/sprites/bwani/moltres.gif','https://play.pokemonshowdown.com/sprites/bw/moltres.png','Known as the legendary bird of fire. Every flap of its wings creates a dazzling flash of flames.'),
(147,'Dratini','Dragon',NULL,'https://play.pokemonshowdown.com/sprites/bwani/dratini.gif','https://play.pokemonshowdown.com/sprites/bw/dratini.png','Long considered a mythical Pokemon until recently when a small colony was found living underwater.'),
(148,'Dragonair','Dragon',NULL,'https://play.pokemonshowdown.com/sprites/bwani/dragonair.gif','https://play.pokemonshowdown.com/sprites/bw/dragonair.png','A mystical Pokemon that exudes a gentle aura. Has the ability to change climate conditions.'),
(149,'Dragonite','Dragon','Flying','https://play.pokemonshowdown.com/sprites/bwani/dragonite.gif','https://play.pokemonshowdown.com/sprites/bw/dragonite.png','An extremely rarely seen marine Pokemon. Its intelligence is said to match that of humans.'),
(150,'Mewtwo','Psychic',NULL,'https://play.pokemonshowdown.com/sprites/bwani/mewtwo.gif','https://play.pokemonshowdown.com/sprites/bw/mewtwo.png','It was created by a scientist after years of horrific gene splicing and DNA engineering experiments.'),
(151,'Mew','Psychic',NULL,'https://play.pokemonshowdown.com/sprites/bwani/mew.gif','https://play.pokemonshowdown.com/sprites/bw/mew.png','So rare that it is still said to be a mirage by many experts. Only a few people have seen it worldwide.');


-- CREATE TABLE IF NOT EXISTS ItemTemplate(
-- 	ItemTemplateID INT PRIMARY KEY,
--     ItemName VARCHAR(255),
--     ItemDescription Text,
--     MoneyClickerMultiplier,
-- 	ImageURL VARCHAR(255)
-- );
-- INSERT INTO ItemTemplate (ItemTemplateID, MoneyClickerMultiplier, ItemName, ImageURL, ItemDescription) VALUES
-- (1, 1.5, "Anti-Pikachu-Rubber-Balloon-Bazooka", 'https://static.wikia.nocookie.net/pokemon/images/f/f2/Anti-PikachuRubber-balloonBazooka.jpg/revision/latest?cb=20190114193334', 'Shoots a rubber balloon that chases Ash\'s Pikachu.'),
-- (2, 1.1, "Bombs", 'https://archives.bulbagarden.net/media/upload/b/ba/EP012_Bombs.png', 'Ordinary bombs. Used by Jessie and James from their balloon to attack Ash and Squirtle.');
INSERT INTO ItemTemplate (ItemTemplateID, ItemName, ItemDescription, MoneyClickerMultiplier, ImageURL) 
VALUES 
(1, 'PokeBall', 'A basic Poké Ball that catches Pokémon.', 1.5, 'https://static.wikia.nocookie.net/pokemon-fano/images/6/6f/Poke_Ball.png'),
(2, 'Rare Candy', 'A candy that levels up a Pokémon by one.', 2.0, 'https://archives.bulbagarden.net/media/upload/5/5e/GO_Rare_Candy.png'),
(3, 'Super Potion', 'Heals a Pokémon by 50 HP.', 1.75, 'https://static.wikia.nocookie.net/pokemonhonorglory/images/a/a3/Bag_Super_Potion_Sprite.png'),
(4, 'TM - Thunderbolt', 'A technical machine that teaches Thunderbolt to an Electric-type Pokémon.', 3.0, 'https://archives.bulbagarden.net/media/upload/thumb/5/5b/TM_artwork_RTDX.png/120px-TM_artwork_RTDX.png'),
(5, 'Eevee Plushie', 'A cute plushie of the Pokémon Eevee.', 1.25, 'https://target.scene7.com/is/image/Target/GUEST_ea37cfc1-aade-4e86-a1b2-bab40592cb91?wid=488&hei=488&fmt=pjpeg'),
(6, 'Pikachu Hat', 'A hat shaped like the Pokémon Pikachu.', 1.5, 'https://i5.walmartimages.com/seo/Pikachu-Snapback-Trucker-Hat-with-Embroidered-Pikachu-Face-Mesh-Panels-and-3D-Ears_349ada45-1715-41fb-a163-f041e259d972_1.62f670c53df7384b029e2ad2a0d89972.jpeg?odnHeight=768&odnWidth=768&odnBg=FFFFFF'),
(7, 'Master Ball', 'The ultimate Poké Ball that catches any Pokémon without fail.', 5.0, 'https://pokemon4ever.org/cdn/shop/products/item_0001.png?v=1674083306'),
(8, 'Lucky Egg', 'An item that increases the experience gained by a Pokémon when held.', 2.5, 'https://archives.bulbagarden.net/media/upload/thumb/0/0c/GO_Lucky_Egg.png/200px-GO_Lucky_Egg.png'),
(9, 'Anti-Pikachu-Rubber-Balloon-Bazooka', 'Shoots a rubber balloon that chases Ash''s Pikachu.', 1.5, 'https://static.wikia.nocookie.net/pokemon/images/f/f2/Anti-PikachuRubber-balloonBazooka.jpg'),
(10, 'Bombs', 'Ordinary bombs. Used by Jessie and James from their balloon to attack Ash and Squirtle.', 1.1, 'https://archives.bulbagarden.net/media/upload/b/ba/EP012_Bombs.png');

-- (1, "Bombs", '', ''),
SELECT * FROM ItemTemplate;
-- (1, "Anti-Pikachu-Rubber-Balloon-Bazooka", 'https://static.wikia.nocookie.net/pokemon/images/f/f2/Anti-PikachuRubber-balloonBazooka.jpg/revision/latest?cb=20190114193334', 'Shoots a rubber balloon that chases Ash\'s Pikachu.'),
-- (1, "Anti-Pikachu-Rubber-Balloon-Bazooka", 'https://static.wikia.nocookie.net/pokemon/images/f/f2/Anti-PikachuRubber-balloonBazooka.jpg/revision/latest?cb=20190114193334', 'Shoots a rubber balloon that chases Ash\'s Pikachu.');


INSERT INTO Users (Username, User_Password, Money) 
VALUES 
('user1', 'password123', 1000.00),
('user2', 'abc123', 500.50),
('user3', 'pass456', 750.25),
('user4', 'userpass', 1200.75),
('user5', 'securepwd', 800.00);

INSERT INTO Pokemon (PokeID, Username, PokeTemplateID) 
VALUES 
(1, 'user1', 1),
(2, 'user1', 3),
(3, 'user2', 2),
(4, 'user3', 1),
(5, 'user4', 4),
(6, 'user4', 5),
(7, 'user5', 3),
(8, 'user5', 2);


-- Single insert statement for Items table
INSERT INTO Items (ItemID, Username, ItemTemplateID)
VALUES 
    (1, 'user1', 1),
    (2, 'user2', 2),
    (3, 'user3', 3),
    (4, 'user1', 4),
    (5, 'user4', 5),
    (6, 'user2', 1),
    (7, 'user5', 2),
    (8, 'user3', 3);


-- Insert statement for UserPosts table with Pokémon-related dummy data
INSERT INTO UserPosts (PostID, Author, PostDescription, ImageURL)
VALUES 
    (1, 'user1', 'Just caught a Pikachu in the forest!', 'https://example.com/pikachu.jpg'),
    (2, 'user2', 'My Charmander evolved into a Charmeleon!', 'https://example.com/charmeleon.jpg'),
    (3, 'user3', 'Battling at the Pokémon gym today!', 'https://example.com/pokemon_gym.jpg'),
    (4, 'user4', 'Found a rare Dragonite near the lake!', 'https://example.com/dragonite.jpg'),
    (5, 'user5', 'Training my Squirtle for the upcoming tournament!', NULL),
    (6, 'user1', 'Caught a shiny Eevee while exploring!', 'https://example.com/shiny_eevee.jpg');


-- Insert statement for Friends table with dummy data
INSERT INTO Friends (Username1, Username2)
VALUES 
    ('user1', 'user2'),
    ('user1', 'user3'),
    ('user2', 'user4'),
    ('user3', 'user5'),
    ('user4', 'user1');

INSERT into sales (Seller, Purchaser, Price) 
values 
	('user1','user2',10.92);