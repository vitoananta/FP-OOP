# FP-OOP



ABOUT

Dalam Final Project (FP) ini saya memustukan untuk membuat “Milky Wars”,
 yaitu sebuah permainan berbasis highscore. User/player akan mengontrol
 sebuah pesawat yang bisa menembak enemy object dan menghabiskan
 Health enemy tersebut untuk mendapatkan sebuah poin. Ketika
 player kehabisan HP, maka permainan akan berakhir.

Tujuan FP ini adalah untuk melatih skill saya dalam pemrograman berorientasi objek
 dengan melibatkan segala aspek yang telah saya pelajari dari berbagai sumber.

OOP ASPECT
OOP aspects that personally applied for the FP:

- Casting/Conversion	: 	Casting double to float (gamesate package: Play class: CollidePlayerInvade/Meteor() method) (Play.java)
	https://github.com/vitoananta/FP-OOP/blob/5518f2035793b05dddef67b64e58bb4570752d17/MilkyWars/src/gamestate/Play.java#L222-L225

	https://github.com/vitoananta/FP-OOP/blob/5518f2035793b05dddef67b64e58bb4570752d17/MilkyWars/src/gamestate/Play.java#L240-L243

- Constructor		: 	Health class (entity package) (Health.java)
	https://github.com/vitoananta/FP-OOP/blob/ad2e5e477dd26fde92ea4a7669a6ea19b3a9b21e/MilkyWars/src/entity/Health.java#L5-L11

- Overloading		: 	spawnInvader() method (gamesate package: Play class) (Play.java)
	https://github.com/vitoananta/FP-OOP/blob/ad2e5e477dd26fde92ea4a7669a6ea19b3a9b21e/MilkyWars/src/gamestate/Play.java#L289-L307

- Overriding		: 	initHitbox() (entitiy package: Invader class & Meteor class) (Invader.java & Meteor.Java)
	https://github.com/vitoananta/FP-OOP/blob/ad2e5e477dd26fde92ea4a7669a6ea19b3a9b21e/MilkyWars/src/entity/Invader.java#L27-L31
	
	https://github.com/vitoananta/FP-OOP/blob/ad2e5e477dd26fde92ea4a7669a6ea19b3a9b21e/MilkyWars/src/entity/Meteor.java#L27-L31
	
- Encapsulation		: 	Getters & Setters (entitiy package: Invader class & Meteor class) (Invader.java & Meteor.Java)
	https://github.com/vitoananta/FP-OOP/blob/ad2e5e477dd26fde92ea4a7669a6ea19b3a9b21e/MilkyWars/src/entity/Meteor.java#L129-L151

- Inheritance		: 	super class: Object class (entitiy package: Object.java) -> sub class: Invader, Meteor (entitiy package: Invader.java & Meteor.Java)
	https://github.com/vitoananta/FP-OOP/blob/ad2e5e477dd26fde92ea4a7669a6ea19b3a9b21e/MilkyWars/src/entity/Object.java#L8-L14
	
	https://github.com/vitoananta/FP-OOP/blob/ad2e5e477dd26fde92ea4a7669a6ea19b3a9b21e/MilkyWars/src/entity/Invader.java#L15
	https://github.com/vitoananta/FP-OOP/blob/ad2e5e477dd26fde92ea4a7669a6ea19b3a9b21e/MilkyWars/src/entity/Meteor.java#L15
	https://github.com/vitoananta/FP-OOP/blob/ad2e5e477dd26fde92ea4a7669a6ea19b3a9b21e/MilkyWars/src/entity/Player.java#L15
	
- Polymorphism		: 	printDetailEnemy()(gamestate package: Play class: spawnInvader & spawnMeteor methods) (Play.java)
	https://github.com/vitoananta/FP-OOP/blob/ad2e5e477dd26fde92ea4a7669a6ea19b3a9b21e/MilkyWars/src/gamestate/Play.java#L296
	https://github.com/vitoananta/FP-OOP/blob/0f66336d306b82ce7bf162fff861302a5b2dfebc/MilkyWars/src/entity/Invader.java#L161-L163
	
	https://github.com/vitoananta/FP-OOP/blob/ad2e5e477dd26fde92ea4a7669a6ea19b3a9b21e/MilkyWars/src/gamestate/Play.java#L322
	https://github.com/vitoananta/FP-OOP/blob/ad2e5e477dd26fde92ea4a7669a6ea19b3a9b21e/MilkyWars/src/entity/Meteor.java#L153-L155

- ArrayList		: 	ArrayList enemys & meteors (Play: initEnemies())
	https://github.com/vitoananta/FP-OOP/blob/0f66336d306b82ce7bf162fff861302a5b2dfebc/MilkyWars/src/gamestate/Play.java#L93-L95

- Exception Handling	: 	Delaying enemies(gamestate package: Play class: initEnemies())
	https://github.com/vitoananta/FP-OOP/blob/0f66336d306b82ce7bf162fff861302a5b2dfebc/MilkyWars/src/gamestate/Play.java#L104-L109

- GUI			: 	Swing: JOptionePane (gamestate package: Play class: updateHighscore()
	https://github.com/vitoananta/FP-OOP/blob/0f66336d306b82ce7bf162fff861302a5b2dfebc/MilkyWars/src/gamestate/Play.java#L106-L108
	
	https://github.com/vitoananta/FP-OOP/blob/0f66336d306b82ce7bf162fff861302a5b2dfebc/MilkyWars/src/gamestate/Play.java#L255-L256

				AWT: Path2D (entity package: Ivander & Meteor class: initHitbox()) (Invader.java & Metor.java)
	https://github.com/vitoananta/FP-OOP/blob/0f66336d306b82ce7bf162fff861302a5b2dfebc/MilkyWars/src/entity/Player.java#L97-L115
	
	https://github.com/vitoananta/FP-OOP/blob/0f66336d306b82ce7bf162fff861302a5b2dfebc/MilkyWars/src/entity/Meteor.java#L86-L96
				
- Interface		: 	EntityMethod (entity pacakge: Enitiy interface) (EntityMethod.Java)
	https://github.com/vitoananta/FP-OOP/blob/0f66336d306b82ce7bf162fff861302a5b2dfebc/MilkyWars/src/entity/EntityMethod.java#L6-L21

- Abstract Class		:	Bullet (entity pacakge: Bullet abstrac class) (Bullet.java)
	https://github.com/vitoananta/FP-OOP/blob/0f66336d306b82ce7bf162fff861302a5b2dfebc/MilkyWars/src/entity/Bullet.java#L3-L14

- Generics		: 	Saving usernames (gamestate package: ListOfUsername class) (ListOfusername.java)
	https://github.com/vitoananta/FP-OOP/blob/0f66336d306b82ce7bf162fff861302a5b2dfebc/MilkyWars/src/gamestate/ListOfUsername.java#L3-L13

- Collection		: 	List for invaders, meteors and lasers (gamestate package: Play class) (Play.java)
	https://github.com/vitoananta/FP-OOP/blob/0f66336d306b82ce7bf162fff861302a5b2dfebc/MilkyWars/src/gamestate/Play.java#L32-L34

- Input Output		:	Highscore (gamestate package: Play class: updateHighscore() & getHighScore()) (Play.java)
	https://github.com/vitoananta/FP-OOP/blob/0f66336d306b82ce7bf162fff861302a5b2dfebc/MilkyWars/src/gamestate/Play.java#L423-L434
	
	https://github.com/vitoananta/FP-OOP/blob/0f66336d306b82ce7bf162fff861302a5b2dfebc/MilkyWars/src/gamestate/Play.java#L254-L284

RUN THIS PROJECT

Untuk menjalankan project ini, diperlukan hal-hal sebagai berikut:
- IDE bebas (disarankan untuk memakai IDE yang terikat dengan bahasa pemrograman Java
 seperti Eclipse, NeatBeans dan Intellij).
- Diperlukan Java Development Kit sebagai Graphical User Interface (Dalam projek ini
 digunakan versi JDK 18.0.2.1 dengan JavaSE-17.
- Clone repository ini, lalu jalankan program dengan normal.



GAME

Berikut beberapa panduan dalam bermain:
Pada menu:
- Button PLAY dapat diaktifkan dengan klik kiri pada mouse atau tekan 'ENTER'
 pada keyboard.
- Button QUIT dapat diaktifkan dengan klik kiri pada mouse.

Pada permainan (setalah klik button PLAY):
- Tekan 'W' untuk maju.
- Tekan 'A' untuk rotasi ke kiri.
- Tekan 'D' untuk rotasi ke kanan.
- Tekan 'SPACEBAR' untuk menembak.
- Tekan 'ESCAPE' untuk keluar dari game (ke menu terlebih dahulu)



ERROR

Terdapat bug dalam project ini yaitu window focus tidak selalu aktif ketika program
 baru saja dijalankan (program tidak bisa menerima input keyboard).
Cara untuk mengatasi masalah tersebut adalah hentikan program tersebut, lalu jalan
 kembali program hingga program dapat menerima input keyboard.
Tips agar kita dapat tahu dengan pasti bahwa program dapat menerima input dengan
 keyboard adalah dengan cara menekan 'ENTER' saat ingin memulai game pada menu game.



DEMO

Video demo (on youtube)
https://youtu.be/EJ2g9W4TkW0 
 
 
 
 
CONTRIBUTING

- Game logics		: https://www.kaaringaming.com/tutorials by Kaarin Gaming
- Input output file	: https://www.youtube.com/watch?v=lHFlAYaNfdo by Alex Lee
- Rotating image	: https://www.youtube.com/watch?v=OqQE3Z87uuU by Coding Explained
- Draw shapes		: https://www.youtube.com/watch?v=zCiMlbu1-aQ&t=2090s by choobtorials
- JOptionPane		: https://www.youtube.com/watch?v=BuW7y21FcYI by Bro Code
- Generics		: https://www.youtube.com/watch?v=K1iu1kXkVoA by Coding with John
- Asset			: 1. https://www.kenney.nl/assets/space-shooter-extension by Kenney
			  2. https://www.kaaringaming.com/tutorials by Kaarin Gaming



SCREENSHOTS

Menu
![menu](https://user-images.githubusercontent.com/115033527/207221920-d881d0cb-650e-45d1-8535-591f9cf21ef5.png)

Play
![play](https://user-images.githubusercontent.com/115033527/207221967-5883d150-cd90-4eb2-b60a-c22d760126f4.png)

Game Over with beated highscore
![gameover](https://user-images.githubusercontent.com/115033527/207221978-ce4bece8-c411-4013-ab27-4933f3cc275d.png)

