const fs = require('fs');
const input = fs.readFileSync('./input.txt').toString().trim().split('\n');
const [N, M, V] = input[0].split(' ').map(Number);
const edges = input.slice(1).map(x => x.split(' ').map(Number));

const graph = Array(N).fill().map(() => []);
for (const [a, b] of edges) { //정점 인접 리스트
    graph[a - 1].push(b - 1);
    graph[b - 1].push(a - 1);
}

// 각 정점의 인접 리스트를 오름차순으로 정렬
for (let i = 0; i < N; i++) {
    graph[i].sort((a, b) => a - b);
}

// DFS
function dfs(start) {
    const visited = new Array(N).fill(false);
    const result = [];

    function go(node) {
        visited[node] = true;
        result.push(node + 1);

        for (const neighbor of graph[node]) {
            if (!visited[neighbor]) {
                go(neighbor);
            }
        }
    }

    go(start - 1);
    return result;
}

// BFS
function bfs(start) {
    const visited = new Array(N).fill(false);
    const result = [];
    const queue = [start - 1];
    visited[start - 1] = true;

    while (queue.length > 0) {
        const node = queue.shift();
        result.push(node + 1);

        for (const neighbor of graph[node]) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                queue.push(neighbor);
            }
        }
    }

    return result;
}

console.log(dfs(V).join(' '));
console.log(bfs(V).join(' '));