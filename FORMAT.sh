#!/bin/bash

echo "=============================="
echo "  C++ Installer for Windows"
echo "=============================="

if ! command -v winget &> /dev/null; then
    echo "[ERROR] winget not found. Please update Windows to get winget."
    exit 1
fi

echo "[1/3] Installing MSYS2 (waiting for completion)..."
winget install --id MSYS2.MSYS2 -e --wait --accept-package-agreements --accept-source-agreements

if [[ $? -ne 0 ]]; then
    echo "[ERROR] MSYS2 installation failed."
    exit 1
fi

echo "[2/3] Installing g++ via MSYS2 (waiting for completion)..."
"C:/msys64/usr/bin/bash.exe" -lc "pacman -S --noconfirm mingw-w64-x86_64-gcc"

if [[ $? -ne 0 ]]; then
    echo "[ERROR] g++ installation failed."
    exit 1
fi

echo "[3/3] Adding g++ to PATH..."
MINGW_BIN="C:/msys64/mingw64/bin"
export PATH="$MINGW_BIN:$PATH"

powershell.exe -Command "
[Environment]::SetEnvironmentVariable(
    'PATH',
    [Environment]::GetEnvironmentVariable('PATH', 'User') + ';$MINGW_BIN',
    'User'
)
"

echo ""
echo "=============================="
echo "Verifying..."
if command -v g++ &> /dev/null; then
    g++ --version
    echo "[SUCCESS] g++ is ready."
else
    echo "[WARN] Restart terminal then run: g++ --version"
fi
echo "=============================="





















# #!/bin/bash

# PASS=0
# FAIL=0
# ERRORS=()

# echo "=============================="
# echo "  COMPILATION CHECK"
# echo "=============================="

# # # Java files
# # for file in *.java; do
# #     [[ -f "$file" ]] || continue
# #     output=$(javac "$file" 2>&1)
# #     if [[ $? -eq 0 ]]; then
# #         echo "[PASS] $file"
# #         PASS=$((PASS + 1))
# #     else
# #         echo "[FAIL] $file"
# #         echo "$output" | sed 's/^/       /'
# #         FAIL=$((FAIL + 1))
# #         ERRORS+=("$file")
# #     fi
# # done

# # C++ files
# for file in *.cpp; do
#     [[ -f "$file" ]] || continue
#     output=$(clang++ -std=c++17 -o /dev/null "$file" 2>&1)
#     if [[ $? -eq 0 ]]; then
#         echo "[PASS] $file"
#         PASS=$((PASS + 1))
#     else
#         echo "[FAIL] $file"
#         echo "$output" | sed 's/^/       /'
#         FAIL=$((FAIL + 1))
#         ERRORS+=("$file")
#     fi
# done

# echo ""
# echo "=============================="
# echo "  PASS: $PASS  |  FAIL: $FAIL"
# echo "=============================="

# if [[ ${#ERRORS[@]} -gt 0 ]]; then
#     echo ""
#     echo "Failed files:"
#     for f in "${ERRORS[@]}"; do
#         echo "  - $f"
#     done
# fi