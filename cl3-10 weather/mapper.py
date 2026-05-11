# mapper.py

import sys

for line in sys.stdin:
    line = line.strip()

    if not line:
        continue

    year, temp = line.split(",")

    print(f"{year}\t{temp}")