Welcome to my project where there is absolutely no comments for absolutely no reason
Because of that I have to explain to your dumb head how this projects works

1st one is in source/Main.java and it is just a summoner which summons the entire thing.
2nd one is source/wrapper these modules are pretty special but can be easily be explained:
  Default.java is the default interface of the user which prints messages handles everything and exits
  it calls Caller.java which we will discuss later and it is the main launcher and Default also have no
  text mode if you don't want a text.
  Caller.java calls everything debugs everything and take care of everything is does not have the flashy
  scanners and printer but has a flashy debugger which debugs something like monster
  -u for un-encrypt and in that mode -k means path to the key -o path to store the solved data -i for
  input data and that's it. while -e stands for encrypt in this mode -k means path to store the keys
  -l for the level of jumbling higher numbers can make it laggy, -i for source file and -o for where
  to store the almost unreadable file.
3rd one is well source/software
  it has one more folder inside while one folder outside called Manifest.java which handles all the call 
  handling. It is through which classes inside handlers are to be called. You can override it but this wiring
  makes it easier to handle stuff because it is easier to know only the requirement than the entire code while wiring
  so this file can be called the circuit box.
  now inside handlers are two files that brings the powers of modules to a small premise. lets dive into:
    Encrypter.java as the name suggests it encrypts stuff the same thing caller calls in -e function
    it handles encryption by by importing modules that you haven't read yet. basically it gets data
    then encrypts it using EBox and reset its value after everything get that lines password and then
    re initiate the values and TaDa.then uses a mystery command called flush writes everything into the file.
    Uncrypter.java as a normal human who doesn't hate common sense like many britains when it comes at using spices
    and it works by using UBox it scrambles the values inside the box to match how it was while encrypted then...
    it solves the character and so on it does its job. then it uses the mystery flush function which writes
    everything to the file
4th is the most hardes modules
  I discourage all non-coders to not read this because it might get more confusing.
  modules have two folders again i will speak about helpers
    helpers has two files 1st comes IO.java
      IO.java handles all IO related thing this is the root of the flush
      function. It has getLines(); function and in this thing everything which
      was read through the read(); function can be retrieved and then there is setLines();
      and this how to set what to write through write(); function.
      and that is it
      assign.java is the file that does a very easy job so you be the analyzer
  Now is the hardes of them all the boxes...
    i discourage every person who is sane to not read this.
      DBox.java is the one that has the first .flush(); function
      the constructor of this file is there to ask for where the data is located and uses the IO
      modules in modules.helpers.IO and reads the file and loads it to data array list then is the
      keys array list which can be filled using the addKey function this is what handles line no. 25
      of Encrypted.java then comes the flush(); function which write everything to the pre-set file
      replace this funtion basically replace the orginal data with encrypted data so flush(); can
      write everything then getData(); and getSize(); are self explanatory.
      EBox.java the most heavy one EBox.reset(); function is pretty self-explanator then comes jumble
      it picks the 2rows where the swap will happen then it picks a random number according to what
      rows where picked. and then swap the selected data and repeats and is determined by what the security
      level was set to. and also records these coordinates. and makes the password. then the search(); function
      which searches where the original data was then checks it in the new data pool and returns it.
      then getPass(); is self explanatory;
      UBox used by Uncrypter.java is just a mix of DBox and EBox its solve function is just searching it in
      reverse order, it checks box array first then it checks where it was originally.
      and rest of them are from DBox.
now this is a slightly a small document but rest of them... you have to read it
Don't worry even though there are no comments but the codes are so small you can learn it in a few minutes.

##Tree
<Java-Encrypter>
  |-classes/
    |-Main.java
    |-modules/
      |-boxes/
        |-EBox.class
        |-UBox.class
        |-DBox.class
      |-helpers/
        |-IO.class
        |-assign.class
    |-software/
      |-handlers/
        |-Encrypter.class
        |-Uncrypter.class
      |-Manifest.class
    |-wrapper/
        |-Default.class
        |-Caller.class
  |-Extra/
    |-Document.md
    |-Encrypter.jar
  |-source/
    |-Main.java
    |-modules/
      |-boxes/
        |-EBox.java
        |-UBox.java
        |-DBox.java
      |-helpers/
        |-IO.java
        |-assign.java
    |-software/
      |-handlers/
        |-Encrypter.java
        |-Uncrypter.java
      |-Manifest.java
    |-wrapper/
      |-Default.java
      |-Caller.java
  |-README.md
  |-LICENSE
