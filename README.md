# hotaabuse
Bot prototype for abusing different banks in HotA version of Heroes of Might and Magic III

How to run locally:

Java program (in future). Currently just Java source code which is in state "works on my machine".
You have several tests in folder test for crypt object:
- on snow with stack of Gremlins and 3 Gargolyas stacks
(see https://www.youtube.com/watch?v=oXRNHmJoL8g&context=C3acc6cbADOEgsToPDskIZm4VHwn9_2mRPL60f_Gyo );
- Tyraxor with 32+ raiders in churchyard (first stack of goblins should be 2);
- begin of abuse (see https://www.youtube.com/watch?v=GOuzFVMKuwI ) of experimental shop.

To run on your machine, you should adjust offset to your OS and window manager
(I am using Ubuntu with xcfe which is pretty rare combination).
Use in tests specific constructor of Environment class with specific Point instead of default one.
To check whether images are corresponding, use CryptTest#readLine. Then compare it with images in resources folder.
Correspondence should be 95% at least by pixels.
