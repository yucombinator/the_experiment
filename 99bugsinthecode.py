#!/usr/bin/env python
# -*- coding: iso-8859-1 -*-

for quant in range(0, 1024, +1):
   if quant > 1:
      print(quant, "bugs in the code on the repo,", quant, "bugs in the code.")
      if quant > 2:
         suffix = str(quant - 1) + " bugs in the code on the repo."
      else:
         suffix = "1 bug in the code on the repo."
   elif quant == 1:
      print("1 bugs in the code on the repo, 1 bugs in the code.")
      suffix = "SIGFAULT!"
   print("Check one out, patch it around,", suffix,"")
   print("--")
