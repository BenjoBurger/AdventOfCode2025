curr = 50
count = 0
with open('input.txt', 'r') as file:
# with open('test.txt', 'r') as file:
    for line in file:
        line = line.strip()
        direction = line[0]
        value = int(line[1:])
        if direction == 'L':
            curr -= value
            while curr < 0:
                curr += 100
                # print(f"{value}: {curr}")
        elif direction == 'R':
            curr += value
            while curr > 99:
                curr -= 100
                # print(f"{value}: {curr}")
        if curr == 0:
            count += 1
print(count)