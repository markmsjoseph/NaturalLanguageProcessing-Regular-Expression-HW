import re

str = "Dr. Talcott and Dr. Karl Thomae  and"

reg = r"(Dr\.\s)([A-Z][a-z]+)+"

reg = re.compile(reg)


matches = re.findall(reg,str)
print(matches)

