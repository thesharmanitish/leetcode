class Solution:
    def lastStoneWeightII(self, stones):
        sums_of_groups = {0}

        total = sum(stones)

        for weight in stones:
            add_sum_of_groups = set()
            for sums in sums_of_groups:
                if weight+sums < total/2:
                    add_sum_of_groups.add(weight+sums)
                elif weight+sums == total/2:
                    return 0;
            sums_of_groups |= add_sum_of_groups
        print(sums_of_groups)
        
        return min(abs(total-2*sums) for  sums in sums_of_groups)