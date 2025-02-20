# Documentation
### Brief Project Report: Text Encryption/Decryption
#### Project Description
The project is a Java program for encrypting and decrypting text. It uses two algorithms:

**1.Caesar Cipher** — shifts letters by a fixed number (key).

**2.Vigenère Cipher —** uses a keyword to shift letters.

The program operates through a console interface. The user selects an operation (encryption or decryption), chooses an algorithm, and inputs the text and key. The result is displayed on the screen.

###### Design Choices
##### 1.Modular Structure:

Each algorithm is implemented separately, making it easy to add new methods.

The main class handles user interaction and program logic.

##### 2.User Interface:

Console menu for selecting operations.

Prompts for text and key input.

##### 3.Extensibility:

New algorithms can be added without changing the core logic.

###### Challenges and Solutions
##### 1.Non-Alphabetic Characters:

The program initially ignored spaces and punctuation.

Solution: Added a check using Character.isLetter().

##### 2.Letter Case:

The case of letters could change during encryption.

Solution: Added checks using Character.isLowerCase() and Character.isUpperCase().

##### 3.Negative Keys for Caesar Cipher:

Negative keys caused errors.

Solution: Adjusted the key using (shift % 26 + 26) % 26.

## Conclusion
The program works correctly and is easy to use. The main issues have been resolved, making it reliable. Future improvements could include adding file support or a graphical interface.

# Sample output:


--- Encryption/Decryption Program ---
1. Encrypt Text
2. Decrypt Text
3. Exit

 ***Choose an option:1***

--- Encryption ---

Enter the text to encrypt:**akyl**

Choose algorithm (1. Caesar Cipher, 2. Vigenère Cipher):**1**

Enter the shift value (key) for Caesar Cipher: **1**

Encrypted Text:**blzm**



--- Encryption/Decryption Program ---
1. Encrypt Text
2. Decrypt Text
3. Exit

***Choose an option: 2***

--- Decryption ---

Enter the text to decrypt: **blzm**

Choose algorithm (1. Caesar Cipher, 2. Vigenère Cipher): **1**

Enter the shift value (key) for Caesar Cipher: **1**

Decrypted Text: **akyl**

--- Encryption/Decryption Program ---
1. Encrypt Text
2. Decrypt Text
3. Exit
 
***Choose an option: 3***
   
Exiting the program. Goodbye!

Process finished with exit code 0

