// Author: Code-Beast

// MY SOLUTION 1 (Divide And Conquer And mergeTwoLists())
// Runtime: 84s

var mergeKLists = function(lists) {
    // Definition of mergeTwolists()
    let mergeTwoLists = function(l1, l2) {
        if (l1 === null) return l2;

        if (l2 === null) return l1;

        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
    
    let length = lists.length;

    if (length === 0) {
        return null;
    }

    if (length === 1) {
        return lists[0];
    } else if (length === 2) {
        return mergeTwoLists(lists[0], lists[1]);
    } else {
        return mergeTwoLists(mergeKLists(lists.slice(0, Math.floor(length / 2))), mergeKLists(lists.slice(Math.floor(length / 2), length)));
    }
};




// // MY SOLUTION 2 (Another Divide And Conquer Solution)
// // Runtime: 80ms
//     var mergeKLists = function(lists) {
//     // Definition of mergeTwolists()
//     let mergeTwoLists = function(l1, l2) {
//         if (l1 === null) return l2;

//         if (l2 === null) return l1;

//         if (l1.val <= l2.val) {
//             l1.next = mergeTwoLists(l1.next, l2);
//             return l1;
//         } else {
//             l2.next = mergeTwoLists(l1, l2.next);
//             return l2;
//         }
//     }

//     if (lists.length === 0) return null;

//     // Divide and Conquer
//     let length = lists.length,
//         interval = 1;
//     while (interval < length) {
//         for (let i = 0; i < length - interval; i += interval * 2) {
//             lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
//         }
//         interval *= 2;
//     }

//     return lists[0];
// };
