#!/usr/bin/python3

import string
import random

letters = string.ascii_letters
numbers = string.digits
symbols = string.punctuation

added = letters + numbers + symbols

length = int(input("Enter the password length: "))
secure_random = random.SystemRandom()

password = "".join(secure_random.sample(added , length))

print(password)