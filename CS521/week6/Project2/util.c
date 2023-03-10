#include "util.h"

#include <stdio.h>
#include <time.h>

/**
 * Converts a number of bytes into a human-readable unit string (MiB, GiB, etc).
 *
 * @param buf Destination character buffer to write the string to
 * @param buf_sz Size of the destination character buffer
 * @param size The size to convert (in bytes)
 * @param decimal_place The number of characters after the decimal place. E.g.,
 *        decimals = 3 would produce output like 4.123 GiB, and decimals = 1
 *        would produce 4.1 GiB.
*/
void human_readable_size(char *buf, size_t buf_sz, double size, unsigned int decimal_place)
{
    // TODO: given a size in bytes, convert it to a human readable size (e.g.,
    // 1024 KiB == 1 MiB).
    //
    // Important: we are *NOT* using SI units. In other words:
    //   1000 KB  = 1 MB     <---- no!
    //   1024 KiB = 1 MiB    <---- this is what we want

    static const char *suffixes[] = {"B", "KiB", "MiB", "GiB", "TiB", "PiB", "EiB", "ZiB"};
    int suffix_index = 0;

    while (size >= 1024 && suffix_index < 7) {
        size /= 1024;
        suffix_index++;
    }
    snprintf(buf, buf_sz, "%.*f %s", decimal_place, size, suffixes[suffix_index]);
}

/**
 * Given a UNIX timestamp, this function converts it to a human-readable string.
 * For example, 1677215473 => Feb 23 2023.
 *
 * @param buf Destination character buffer to write the string to
 * @param buf_sz Size of the destination character buffer
 * @param time UNIX timestamp
*/
size_t simple_time_format(char *buf, size_t buf_sz, time_t time)
{
    return strftime(buf, buf_sz, "%b %d %Y", localtime(&time));
}
