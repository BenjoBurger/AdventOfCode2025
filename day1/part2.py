curr = 50
count = 0
ignore = False
# with open('input.txt', 'r') as file:
with open('test.txt', 'r') as file:
    for line in file:
        line = line.strip()
        direction = line[0]
        value = int(line[1:])
        if direction == 'L':
            if curr == 0:
                count -= 1
            curr -= value
            count += abs(curr // 100)
            curr %= 100
            print(f"{line}: {curr}")
            # print(f"Count: {count}")
        elif direction == 'R':
            curr += value
            count += abs(curr // 100)
            curr %= 100
            if curr == 0:
                count -= 1
            print(f"{line}: {curr}")
            # print(f"Count: {count}")
        if curr == 0:
            count += 1
        print(f"Current: {curr}, Count: {count}")
print(count)

print(-14%100)

# Lower 6606
# Upper 7738