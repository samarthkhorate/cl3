# reducer.py

import sys

current_year = None
temp_sum = 0
count = 0

year_avg = {}

for line in sys.stdin:
    line = line.strip()

    year, temp = line.split("\t")
    temp = float(temp)

    if current_year == year:
        temp_sum += temp
        count += 1

    else:
        if current_year:
            avg = temp_sum / count
            year_avg[current_year] = avg

        current_year = year
        temp_sum = temp
        count = 1

# Last year calculation
if current_year:
    avg = temp_sum / count
    year_avg[current_year] = avg

# Find hottest and coolest year
hottest_year = max(year_avg, key=year_avg.get)
coolest_year = min(year_avg, key=year_avg.get)

print("\nAverage Temperature by Year:")
for year, avg in year_avg.items():
    print(f"{year} -> {avg:.2f}")

print("\nHottest Year:")
print(f"{hottest_year} -> {year_avg[hottest_year]:.2f}")

print("\nCoolest Year:")
print(f"{coolest_year} -> {year_avg[coolest_year]:.2f}")