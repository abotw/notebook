import os

# 所有文件名列表
filenames = [
    "ch01-24-txdsol-p05",
    "ch02-01-txdsol-p09",
    "ch02-08-txdsol-p10",
    "ch03-08-txdsol-p15",
    "ch03-19-txdsol-p17",
    "ch03-20-txdsol-p18",
    "ch03-22-txdsol-p19",
    "ch04-13-txdsol-p25",
    "ch04-19-txdsol-p28",
    "ch04-20-txdsol-p28",
    "ch05-10-txdsol-p32",
    "ch05-15-txdsol-p33",
    "ch05-17-txdsol-p34",
    "ch06-12-txdsol-p39",
    "ch06-18-txdsol-p41",
    "ch07-05-txdsol-p44",
    "ch07-17-txdsol-p47",
    "ch07-18-txdsol-p47",
    "ch08-04-txdsol-p50",
    "ch08-14-txdsol-p53",
    "ch09-16-txdsol-p59"
]

# 输出文件目录
output_dir = "txdsol"

# 创建目录
os.makedirs(output_dir, exist_ok=True)

# 创建每个文件
for name in filenames:
    file_path = os.path.join(output_dir, f"{name}.md")
    if not os.path.exists(file_path):
        with open(file_path, "w", encoding="utf-8") as f:
            f.write(f"# {name}\n\n")
        print(f"✅ Created: {file_path}")
    else:
        print(f"⚠️ Skipped (already exists): {file_path}")
