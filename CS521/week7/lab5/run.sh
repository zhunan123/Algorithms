#!/usr/bin/env bash

rm -f *.out
echo "Starting benchmark"
for (( i = 0; i <= 40; i += 10 )); do
    export ALLOC_THRESH=$i
    output_file=$(printf "%03d.out" "${i}")
    echo -n "${i}..."
    LD_PRELOAD=$(pwd)/allocator.so /usr/bin/time -q -f "%e" \
        -o "${output_file}" find / &> /dev/null
    sed -i "1s/^/${i}\t/" "${output_file}" # Add threshold to beginning of file
done
echo 'done!'

echo 'Combining outputs into benchmark.out...'
cat *.out > benchmark.out